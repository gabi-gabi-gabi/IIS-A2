import { useEffect, useState } from "react";
import { getMode, setMode } from "../services/api";

function ModeSelector() {
    const [mode, setCurrentMode] = useState("");
    useEffect(() => {loadMode();}, []);
    const loadMode = async () => {
        const response = await getMode();
        setCurrentMode(response.data);
    };
    const changeMode = async (event) => {
        const newMode = event.target.value;
        await setMode(newMode);
        setCurrentMode(newMode);
    };
    return (
        <div>
            <h2>
                Agent Mode
            </h2>
            <label>
                <input
                    type="radio"
                    value="SUGGESTION"
                    checked={
                        mode ===
                        "SUGGESTION"
                    }
                    onChange={
                        changeMode
                    }
                />
                Suggestion
            </label>
            <br />
            <label>
                <input
                    type="radio"
                    value="APPROVAL"
                    checked={
                        mode ===
                        "APPROVAL"
                    }
                    onChange={
                        changeMode
                    }
                />
                Approval
            </label>
            <br />
            <label>
                <input
                    type="radio"
                    value="AUTONOMOUS"
                    checked={
                        mode ===
                        "AUTONOMOUS"
                    }
                    onChange={
                        changeMode
                    }
                />
                Autonomous
            </label>
        </div>
    );
}

export default ModeSelector;