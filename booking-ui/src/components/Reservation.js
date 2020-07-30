import React, {useRef} from 'react';
import {useHistory} from "react-router-dom";
import ReservationService from "../service/ReservationService";
import {RoutesUI} from "../constant/RoutesUI";
import '../styles/Creator.css'
import RoomService from "../service/RoomService";
import Card from "@material-ui/core/Card/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";

export default function Reservation(props) {
    const history = useHistory();

    const dateStartRef = useRef(null);
    const dateEndRef = useRef(null);
    const roomIdRef = useRef(null);
    const userIdRef = useRef(null);
    const nameRef = useRef(null);
    const descriptionRef = useRef(null);

    const saveReservation = () => {
        const body = JSON.stringify({
            date_start: dateStartRef.current.value,
            date_end: dateEndRef.current.value,
            room_id: roomIdRef.current.value,
            user_id: userIdRef.current.value,
            name: nameRef.current.value,
            description: descriptionRef.current.value,
        });
        ReservationService.createReservation(body).then(r => history.push(RoutesUI.cabinet))
    };

    const getRoomsForReservation = (start, end, userId) => {
        RoomService.getAvailableRoomsForUser(start, end, userId).then(room => {
            console.log(room);
            return (
                <Card key={room.id} className="margin-vertical">
                    <CardHeader title={room.name}/>
                    <CardContent>
                        <Typography variant="body2" color="textSecondary">{room.room_type}</Typography>
                        <Typography>{room.location}</Typography>
                    </CardContent>
                </Card>
            )
        })
    };

    return (
        <div className="container-box">
            <h2>Book a room!</h2>

            <div className="fields">
                <span>Date start</span>
                <input id="datetime" type="datetime-local" ref={dateStartRef}/>

                <span>Date end</span>
                <input id="datetime" type="datetime-local" ref={dateEndRef}/>

                <button onClick={getRoomsForReservation(dateStartRef, dateEndRef, userIdRef)}>Find</button>
            </div>

            {/*<label><input type="radio" name="coffee" value="without"/>room</label>*/}

            <div className="fields">
                <span>Room id</span>
                <input ref={roomIdRef}/>
                <span>User id</span>
                <input ref={userIdRef}/>

                <span>Reservation name*</span>
                <input name="reservation-name" required ref={nameRef}/>

                <span>Reservation description</span>
                <textarea ref={descriptionRef} className="short-text"/>

                <button onClick={saveReservation}>To book</button>
            </div>
        </div>
    );
}
