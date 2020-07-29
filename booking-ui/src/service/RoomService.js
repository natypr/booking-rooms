import {
    ROOMS_REQUEST_STRING,
    METHOD_GET,
    REDIRECT_VALUE,
    METHOD_POST,
    CONTENT_TYPE,
    APPLICATION_JSON
} from "../constant/AppConstants";

class RoomService {

    async createRequestOptionsGet() {
        return {
            method: METHOD_GET,
            redirect: REDIRECT_VALUE,
        };
    }

    async getRoomList() {
        const requestOptions = await this.createRequestOptionsGet();
        const response = await fetch(ROOMS_REQUEST_STRING, requestOptions);
        return await response.json();
    }

    async getRoom(id) {
        const requestOptions = await this.createRequestOptionsGet();
        let requestString = ROOMS_REQUEST_STRING + "/" + id;
        const response = await fetch(requestString, requestOptions);
        return await response.json();
    }

    async createRoom(raw) {
        const myHeaders = new Headers();
        myHeaders.append(CONTENT_TYPE, APPLICATION_JSON);

        const requestOptions = {
            method: METHOD_POST,
            headers: myHeaders,
            body: raw,
            redirect: REDIRECT_VALUE,
        };
        const response = await fetch(ROOMS_REQUEST_STRING, requestOptions);
        return await response.json();
    }
}

export default new RoomService();
