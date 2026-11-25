import CalendarView from "./components/CalendarView";
import ModeSelector from "./components/ModeSelector";
import AgentPanel from "./components/AgentPanel";

function App() {
    return (
        <div>
            <h1>AI Scheduling Agent</h1>
            <ModeSelector />
            <AgentPanel />
            <CalendarView />
        </div>
    );
}

export default App;