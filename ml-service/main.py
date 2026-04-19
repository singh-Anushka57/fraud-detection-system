from fastapi import FastAPI
import joblib
import numpy as np

app = FastAPI()

model = joblib.load("model.pkl")

@app.get("/")
def home():
    return {"message": "Fraud Detection API Running"}

@app.post("/predict")
def predict(amount: float, time: float):
    data = np.array([[amount, time]])
    prediction = model.predict(data)
    return {"fraud": int(prediction[0])}