import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import joblib

data = pd.DataFrame({
    "amount": [100, 2000, 5000, 10000],
    "time": [1, 2, 3, 4],
    "fraud": [0, 0, 1, 1]
})

X = data.drop("fraud", axis=1)
y = data["fraud"]

model = RandomForestClassifier()
model.fit(X, y)

joblib.dump(model, "model.pkl")

print("Model trained successfully")