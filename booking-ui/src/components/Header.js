import React from 'react';
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import {Link} from "react-router-dom";
import '../styles/Header.css';
import {RoutesUI} from "../constant/RoutesUI";
import Typography from "@material-ui/core/Typography";

export default function Header() {

    return (
        <AppBar position="static">
            <Toolbar>
                <Link className="link" to={RoutesUI.rooms}>All rooms</Link>
                <Link className="link" to={RoutesUI.creator}>Create</Link>
                <Link className="link" to={RoutesUI.reservation}>Reservation</Link>
                <Link className="link" to={RoutesUI.cabinet}>My cabinet</Link>
                <Typography variant="overline" color="inherit">Hi, name...</Typography>
            </Toolbar>
        </AppBar>
    );
}
