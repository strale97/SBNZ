import React, { useEffect } from "react";
import Axios from "axios";
import Prikaz from "../konfiguracije/Prikaz";
import {
    Container, 
    Paper,
    Select,
    Checkbox,
    MenuItem,
    Button,
  } from "@material-ui/core";

const Pregled = (props) => {
    const [konfiguracije, setKonfiguracije] = React.useState([]);
    const [os, setOs] = React.useState("NA");
    const [osOptions] = React.useState(["NA", "Windows", "Linux"]);
    const [laptop, setLaptop] = React.useState(false);
    const prikazKonfiguracija = konfiguracije.map((konf) => (
        <Prikaz konfiguracija = {konf} key = {konf.id}/>
    ));
    const handleCheckLaptop = (event) => {
        setLaptop(event.target.checked);
    };
    const handleSelectChangeOs = (event) => {
        setOs(event.target.value);
    };
    const osOptionsList = osOptions.map((opt) => (
        <MenuItem key={opt} value={opt}>
          {opt}
        </MenuItem>
    ));
    useEffect(() => {
        Axios.get("http://localhost:8080/get").then((response) => {
          setKonfiguracije(response.data);
        });
      }, [props]);
    const submitForm = () => {
        let filter = {
          os: os,
          laptop: laptop
        };
        console.log(filter);
        Axios.post(
          "http://localhost:8080/filter",
          filter
        ).then((response) => setKonfiguracije(response.data));
    };
  return (
    <Container className="form-container">
        <Paper>
            <form>
                <label>Laptop:</label>
                <Checkbox checked={laptop} onChange={handleCheckLaptop} />
                
                <label>Operativni sistem:</label>
                <Select
                    id="os"
                    value={os}
                    onChange={handleSelectChangeOs}
                >
                    {osOptionsList}
                </Select>
                <Button variant="contained" color="primary" onClick={submitForm}>
                    Filtriraj
                </Button>
            </form>
        </Paper>
        {prikazKonfiguracija}
    </Container>
  );
};

export default Pregled;
