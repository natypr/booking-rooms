import {
    APPLICATION_JSON,
    CONTENT_TYPE,
    METHOD_POST,
    REDIRECT_VALUE,
    USERS_REQUEST_STRING
} from "../constant/AppConstants";

class UserService {

    async createUser(raw) {
        const myHeaders = new Headers();
        myHeaders.append(CONTENT_TYPE, APPLICATION_JSON);

        const requestOptions = {
            method: METHOD_POST,
            headers: myHeaders,
            body: raw,
            redirect: REDIRECT_VALUE,
        };
        const response = await fetch(USERS_REQUEST_STRING, requestOptions);
        return await response.json();
    }
}

export default new UserService();
