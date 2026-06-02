import logging

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from .schemas import ChatRequest, ChatResponse
from .middleware import add_process_time
from .routers import chat_langchain, chat_crew
from .errors import handle_unexpected

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(name)s — %(message)s",
)

app = FastAPI(title="AI Backend", version="1.0.0")

# 미들웨어 — 등록 순서 역순으로 실행됩니다
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173", "http://localhost:8080"],
    allow_credentials=True,  # 쿠키 등 인증 정보 허용 여부
    allow_methods=["*"],  # HTTP 메서드, 와일드카드(모두 허용)
    allow_headers=["*"],  # HTTP 헤더, 와일드카드(모두 허용)
)
app.middleware("http")(add_process_time)  # 요청 처리 시간 측정(커스텀 미들웨어)

# 예외 핸들러
app.add_exception_handler(Exception, handle_unexpected)

# 라우터 등록
app.include_router(chat_langchain.router)
app.include_router(chat_crew.router)

@app.get("/health", tags=["meta"])
def health() -> dict[str, str]:
    """헬스 체크 — Docker/k8s liveness 용도."""
    return {"status": "ok"}

@app.post("/echo", tags=["meta"])
def echo(req: ChatRequest) -> ChatResponse:
    """Pydantic v2 검증 시연용 echo 엔드포인트."""
    return ChatResponse(answer=req.prompt, model="echo-1")
