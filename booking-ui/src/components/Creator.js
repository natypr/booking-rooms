import React, {useRef} from 'react';
import {useHistory} from "react-router-dom";
import RoomService from "../service/RoomService";
import UserService from "../service/UserService";
import {RoutesUI} from "../constant/RoutesUI";
import '../styles/Creator.css'

export default function Creator(props) {
    const history = useHistory();

    const nameRef = useRef(null);
    const roomTypeRef = useRef(null);
    const locationRef = useRef(null);
    const userNameRef = useRef(null);

    const saveRoom = () => {
        const body = JSON.stringify({
            location: locationRef.current.value,
            name: nameRef.current.value,
            room_type: roomTypeRef.current.value,
        });
        RoomService.createRoom(body).then(r => history.push(RoutesUI.rooms))
    };

    const saveUser = () => {
        const body = JSON.stringify({
            name: userNameRef.current.value,
        });
        UserService.createUser(body).then(r => history.push(RoutesUI.cabinet))
    };

    return (
        <div className="container-box">
            <h2>Create room</h2>
            <div className="fields">
                <span>Room name</span>
                <input name="room-name" required ref={nameRef}/>
                <span>Room type</span>
                <select defaultValue="RESTROOM" ref={roomTypeRef}>
                    <option>RESTROOM</option>
                    <option>DRESSING</option>
                    <option>OPERATING</option>
                </select>
                <span>Room location</span>
                <textarea ref={locationRef} className="short-text"/>
                <button onClick={saveRoom}>Save</button>
            </div>

            <h2>Create user</h2>
            <div className="fields">
                <span>User Name</span>
                <input ref={userNameRef}/>
                <button onClick={saveUser}>Save</button>
            </div>
        </div>
    );
}
