function ExplanationPanel({ response, approve, undo }) {
    if (!response) {return null;}
    return (
        <div
            style={{
                border: "1px solid grey",
                marginTop: "15px",
                padding: "10px"
            }}
        >
            <h3>
                Outcome:
            </h3>
            <p>
                {response.explanation}
            </p>
            {response.mode === "APPROVAL" && (
                <button onClick={approve}>
                    Approve Recommendation
                </button>
            )}
            {(response.mode === "APPROVAL" || response.mode === "AUTONOMOUS") && (
                <button onClick={undo}>
                    Undo Last Action
                </button>
            )}
            <p>
                Risk Level: {response.risk}
            </p>
        </div>
    );
}

export default ExplanationPanel;