import {
    APPLICATION_JSON,
    CONTENT_TYPE,
    METHOD_GET,
    METHOD_POST,
    REDIRECT_VALUE,
    ROOMS_REQUEST_STRING
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

    async getAvailableRoomsForUser(start, end, userId) {
        const requestOptions = await this.createRequestOptionsGet();
        let requestString = ROOMS_REQUEST_STRING + "/" + userId + "/d?start=" + start + "&end=" + end;
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
