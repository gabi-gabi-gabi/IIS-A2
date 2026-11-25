import { useState } from "react";
import { analyseCalendar, approveRecommendation, undoChange } from "../services/api";
import ExplanationPanel from "./ExplanationPanel";

function AgentPanel() {
    const [response, setResponse] =useState(null);
    const analyse = async () => {
        try {
            const result = await analyseCalendar();
            setResponse(result.data);
        } catch(error) {
            console.error(error);
        }
    };
    const approve = async () => {
        try{
            await approveRecommendation();
            alert("Recommendation approved");
        } catch(error) {
            console.error(error);
        }
    }
    const undo = async () => {
        try {
            await undoChange();
            alert("Undo successful");
        } catch(error) {
            console.error(error);
        }
    };
    return (
        <div
            style={{
                marginTop: "20px",
                border: "1px solid black",
                padding: "15px"
            }}
        >
            <h2>
                Scheduling Agent
            </h2>
            <button
                onClick={analyse}
            >
                Analyse Calendar
            </button>
            {response && (
                <div
                    style={{
                        marginTop: "15px"
                    }}
                >
                    <p>
                        <strong>
                            Mode:
                        </strong>{" "}
                        {response.mode}
                    </p>
                    <p>
                        <strong>
                            Action:
                        </strong>{" "}
                        {response.action}
                    </p>
                    <p>
                        <strong>
                            Message:
                        </strong>{" "}
                        {response.message}
                    </p>
                    <p>
                        <strong>
                            Executed:
                        </strong>{" "}
                        {response.executed
                            ? "Yes"
                            : "No"}
                    </p>
                    <p>
                        {response && response.action !== "NONE" && (<ExplanationPanel response={response} approve={approve} undo={undo} />)}
                    </p>
                </div>
            )}
        </div>
    );
}

export default AgentPanel;