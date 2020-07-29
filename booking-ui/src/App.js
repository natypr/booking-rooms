import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import RoomList from "./components/RoomList";
import {RoutesUI} from "./constant/RoutesUI";
import Room from "./components/Room";
import Header from "./components/Header";
import Creator from "./components/Creator";
import Reservation from "./components/Reservation";
import Cabinet from "./components/Cabinet";

export default function App() {

    return (
        <div className="app">
            <BrowserRouter>
                <Header/>
                <Route path={RoutesUI.rooms} exact component={RoomList}/>
                <Route path={RoutesUI.roomId} component={Room}/>
                <Route path={RoutesUI.creator} component={Creator}/>
                <Route path={RoutesUI.reservation} component={Reservation}/>
                <Route path={RoutesUI.cabinet} component={Cabinet}/>
            </BrowserRouter>
        </div>
    )
}
