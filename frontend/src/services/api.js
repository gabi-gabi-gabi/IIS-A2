import axios from "axios";

const API_URL = "http://localhost:8080";

export const getEvents = async () => {
    return axios.get(`${API_URL}/events`);
};
export const getMode = async () => {
    return axios.get(`${API_URL}/mode`);
};
export const setMode = async (mode) => {
    return axios.post(`${API_URL}/mode`, { mode });
};
export const analyseCalendar = async () => {
    return axios.get(`${API_URL}/agent`);
};
export const approveRecommendation = async () => {
    return axios.post(`${API_URL}/agent/approve`);
};
export const undoChange = async () => {
      return axios.post(`${API_URL}/undo`);
};