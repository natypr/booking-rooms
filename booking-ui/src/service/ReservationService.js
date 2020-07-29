import {
    APPLICATION_JSON,
    CONTENT_TYPE,
    METHOD_DELETE,
    METHOD_GET,
    METHOD_POST,
    REDIRECT_VALUE,
    RESERVATIONS_REQUEST_STRING
} from "../constant/AppConstants";

class ReservationService {

    async createRequestOptionsGet() {
        return {
            method: METHOD_GET,
            redirect: REDIRECT_VALUE,
        };
    }

    async getReservationList() {
        const requestOptions = await this.createRequestOptionsGet();
        const response = await fetch(RESERVATIONS_REQUEST_STRING, requestOptions);
        return await response.json();
    }

    async getReservation(id) {
        const requestOptions = await this.createRequestOptionsGet();
        let requestString = RESERVATIONS_REQUEST_STRING + "/" + id;
        const response = await fetch(requestString, requestOptions);
        return await response.json();
    }

    async getReservationByUserId(userId) {
        const requestOptions = await this.createRequestOptionsGet();
        let requestString = RESERVATIONS_REQUEST_STRING + "/user/" + userId;
        const response = await fetch(requestString, requestOptions);
        return await response.json();
    }

    async createReservation(raw) {
        const myHeaders = new Headers();
        myHeaders.append(CONTENT_TYPE, APPLICATION_JSON);

        const requestOptions = {
            method: METHOD_POST,
            headers: myHeaders,
            body: raw,
            redirect: REDIRECT_VALUE,
        };
        const response = await fetch(RESERVATIONS_REQUEST_STRING, requestOptions);
        return await response.json();
    }

    async deleteReservation(id) {
        const requestOptions = {
            method: METHOD_DELETE,
            redirect: REDIRECT_VALUE,
        };
        let requestString = RESERVATIONS_REQUEST_STRING + "/" + id;
        const response = await fetch(requestString, requestOptions);
        return await response.json();
    }
}

export default new ReservationService();
