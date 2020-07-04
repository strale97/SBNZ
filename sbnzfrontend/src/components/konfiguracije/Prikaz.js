import React from "react";
import {
  Container,
  Paper,
} from "@material-ui/core";

const Prikaz = (props) => {
  const prikazHardDrajvova = props.konfiguracija.hardDrives.map((hd) => (
    <tr>
      <td colSpan="2">{hd.ime}</td>
    </tr>
  ));


  let laptop;
  if (props.konfiguracija.laptop) {
    laptop = <tr>
      <td>Laptop:</td>
      <td>Da</td>
    </tr>
  } else {
    laptop = <tr>
    <td>Laptop:</td>
    <td>Ne</td>
  </tr>
  }

  let os;
  if (props.konfiguracija.os !== "NA") {
    os =  <tr>
            <td>Operativni sistem:</td>
            <td>{props.konfiguracija.os}</td>
          </tr>
  } else {
    os = <tr>
    <td>Operativni sistem:</td>
    <td>Nema operativni sistem</td>
  </tr>
  }
  
  return (
    <Container className="prikaz">
      <Paper elevation={3} className="konfiguracija" id={props.konfiguracija.id}>
        <div><b>{props.konfiguracija.ime}</b></div>
        <br />
        <table>
          <tbody>
            <tr>
              <th>CPU:</th>
              <th>{props.konfiguracija.cpu.ime}</th>
            </tr>
            <tr>
              <td>Broj jezgara:</td>
              <td>{props.konfiguracija.cpu.jezgra}</td>
            </tr>
            <tr>
              <td>Broj tredova:</td>
              <td>{props.konfiguracija.cpu.tredovi}</td>
            </tr>
            <tr>
              <td>Brzina procesora:</td>
              <td>{props.konfiguracija.cpu.brzina}</td>
            </tr>
            <tr>
              <th>GPU:</th>
              <th>{props.konfiguracija.gpu.ime}</th>
            </tr>
            <tr>
              <td>Tip memorije:</td>
              <td>{props.konfiguracija.gpu.tipMemorije}</td>
            </tr>
            <tr>
              <td>Kolicina memorije:</td>
              <td>{props.konfiguracija.gpu.memorija}</td>
            </tr>
            <tr>
              <th>RAM memorija:</th>
              <th>{props.konfiguracija.ram.memorija} {props.konfiguracija.ram.tipMemorije} {props.konfiguracija.ram.brzina}MHz</th>
            </tr>
            <tr>
              <th colSpan="2">Hard drajvovi:</th>
            </tr>
            {prikazHardDrajvova}
            {os}
            {laptop}
            <tr>
              <td>Cena:</td>
              <td>{props.konfiguracija.cena}</td>
            </tr>
          </tbody>
        </table>
        <br />
        <div>
          <a href={props.konfiguracija.link}>Link ka sajtu konfiguracije</a>
        </div>
      </Paper>
    </Container>
  );
};

export default Prikaz;
