import React, {useEffect, useState} from 'react';
import RoomService from "../service/RoomService";
import Container from "@material-ui/core/Container";
import {RoutesUI} from "../constant/RoutesUI";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import '../styles/Header.css'

export default function RoomList(props) {

    const [rooms, setRooms] = useState([]);

    useEffect(() => {
        RoomService.getRoomList().then(r => setRooms(r))
    });

    const renderRoomList = rooms.map(room => {
        return (
            <Card key={room.id} className="margin-vertical">
                <CardHeader title={room.name} onClick={() => props.history.push(RoutesUI.room + room.id)}/>
                <CardContent>
                    <Typography variant="body2" color="textSecondary">{room.room_type}</Typography>
                    <Typography>{room.location}</Typography>
                </CardContent>
            </Card>
        )
    });

    return (
        <div>
            <Container maxWidth="sm">
                <Typography variant="h4" color="textPrimary">Catalog of all rooms</Typography>
                {renderRoomList}
            </Container>
        </div>
    );
}
