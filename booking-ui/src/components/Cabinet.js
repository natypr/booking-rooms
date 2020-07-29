import React, {useEffect, useState} from 'react';
import ReservationService from "../service/ReservationService";
import Container from "@material-ui/core/Container";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import '../styles/Header.css'
import Button from "@material-ui/core/Button";
import CardActions from "@material-ui/core/CardActions";
import {useHistory} from "react-router-dom";

export default function Cabinet(props) {
    const history = useHistory();

    const [reservations, setReservations] = useState([]);

    useEffect(() => {
        ReservationService.getReservationList().then(r => setReservations(r))
    }, []);

    const deleteReservation = (id) => {
        //ReservationService.deleteReservation(id).then(r => console.log(r))
    };

    const renderReservationList = reservations.map(r => {
        return (
            <Card key={r.id} className="margin-vertical">
                <CardHeader title={r.name}/>
                <CardContent>
                    <Typography variant="body2" color="textSecondary">Start date: {r.date_start}</Typography>
                    <Typography variant="body2" color="textSecondary">End date: {r.date_end}</Typography>
                    <Typography variant="body2" color="textSecondary">Description: {r.description}</Typography>
                    <Typography variant="body2" color="textSecondary">Room id: {r.room_id}</Typography>
                    <Typography variant="body2" color="textSecondary">User id: {r.user_id}</Typography>
                </CardContent>
                <CardActions>
                    <Button variant="contained" color="secondary" onClick={deleteReservation(r.id)}>
                        Cancel reservation
                    </Button>
                </CardActions>
            </Card>
        )
    });

    return (
        <div>
            <Container maxWidth="sm">
                <Typography variant="h5" color="textPrimary">Rooms that have been booked by me</Typography>
                {renderReservationList}
            </Container>
        </div>
    );
}
