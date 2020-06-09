import React from "react";
import {
  Container,
  Paper,
  TextField,
  Button
} from "@material-ui/core";
import Axios from "axios";

const DodajPravilo = (props) => {
  const [pravilo, setPravilo] = React.useState("");
  const [ime, setIme] = React.useState("");
  
  const submitForm = () => {
    console.log(pravilo);
    let drl = {
      text: pravilo,
      ime: ime
    };
    Axios.post(
      "http://localhost:8080/dodajPravilo",
      drl, {headers: {"X-Auth-Token": props.accessToken}}
    ).then((response) => console.log(response.data));
  };

  return (
    <Container className="dodajPravilo">
      <Paper elevation={3} className="text">
        <form>
        <TextField 
            label="Pravilo"
            value={pravilo}
            variant="outlined"
            multiline
            onChange={(event) => setPravilo(event.target.value)} 
        />
        <TextField label="Ime fajla" value={ime} onChange={(event) => setIme(event.target.value)} />
        <Button variant="contained" color="primary" onClick={submitForm}>
            Dodaj pravilo
          </Button>
        </form>
      </Paper>
    </Container>
  );
};

export default DodajPravilo;
