import React, { useState } from "react";
import "./App.css";

import Zahtev from "./components/konfiguracije/Zahtev";
import Pregled from "./components/konfiguracije/Pregled";
import Login from "./components/user/Login";
import Navbar from "./components/layout/Navbar";
import DodajPravilo from "./components/user/DodajPravilo"

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  const [accessToken] = useState(localStorage.getItem("access_token"));

  return (
    <div className="App">
      <Router>
        <Navbar />
        <Switch>
          <Route path="/zahtevi">
            <Zahtev />
          </Route>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/pravilo">
            <DodajPravilo accessToken={accessToken} />
          </Route>
          <Route path="/">
            <Pregled />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
