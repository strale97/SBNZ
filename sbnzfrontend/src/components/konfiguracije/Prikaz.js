import React from "react";
import {
  Container,
  Paper,
} from "@material-ui/core";

const Prikaz = (props) => {
  
  return (
    <Container className="prikaz">
      <Paper elevation={3} className="konfiguracija">
        <div>Ime konfiguracije: {props.konfiguracija.ime}</div>
        <div>CPU: {props.konfiguracija.cpu.ime}</div>
        <div>GPU: {props.konfiguracija.gpu.ime}</div>
        <div>Cena: {props.konfiguracija.cena}</div>
      </Paper>
    </Container>
  );
};

export default Prikaz;
