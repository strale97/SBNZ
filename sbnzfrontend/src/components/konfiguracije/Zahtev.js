import React from "react";
import {
  TextField,
  Select,
  Checkbox,
  MenuItem,
  Button,
  Container,
  Paper,
} from "@material-ui/core";
import Axios from "axios";
import FormTitle from "../layout/FormTitle";
import Prikaz from "../konfiguracije/Prikaz";

const Zahtev = (props) => {
  const [budzet, setBudzet] = React.useState("");
  const [laptop, setLaptop] = React.useState(false);
  const [upotreba, setUpotreba] = React.useState("web surfing");
  const [upotrebaOptions] = React.useState(["web surfing", "gaming", "video editing"]);
  const [prefGpu, setPrefGpu] = React.useState("NONE");
  const [prefGpuOptions] = React.useState(["NONE", "NVIDIA", "AMD"]);
  const [prefCpu, setPrefCpu] = React.useState("NONE");
  const [prefCpuOptions] = React.useState(["NONE", "Intel", "AMD"]);
  const [koristioPre, setKoristioPre] = React.useState(false);
  const [os, setOs] = React.useState("NA");
  const [osOptions] = React.useState(["NA", "Windows", "Linux"]);
  const [konfiguracije, setKonfiguracije] = React.useState([]); 
  
  const handleCheckLaptop = (event) => {
    setLaptop(event.target.checked);
  };
  const handleCheckKoristioPre = (event) => {
    setKoristioPre(event.target.checked);
  };
  const handleSelectChangeUpotreba = (event) => {
    setUpotreba(event.target.value);
  };
  const handleSelectChangePrefGpu = (event) => {
    setPrefGpu(event.target.value);
  };
  const handleSelectChangePrefCpu = (event) => {
    setPrefCpu(event.target.value);
  };
  const handleSelectChangeOs = (event) => {
    setOs(event.target.value);
  };
  const submitForm = () => {
    let zahtev = {
      budzet: budzet,
      laptop: laptop,
      upotreba: upotreba,
      prefGpu: prefGpu,
      prefCpu: prefCpu,
      koristioPre: koristioPre,
      os: os,
    };
    console.log(zahtev);
    Axios.post(
      "http://localhost:8080/test",
      zahtev
    ).then((response) => setKonfiguracije(response.data));
  };
  const upotrebaOptionsList = upotrebaOptions.map((opt) => (
    <MenuItem key={opt} value={opt}>
      {opt}
    </MenuItem>
  ));
  const prefGpuOptionsList = prefGpuOptions.map((opt) => (
    <MenuItem key={opt} value={opt}>
      {opt}
    </MenuItem>
  ));
  const prefCpuOptionsList = prefCpuOptions.map((opt) => (
    <MenuItem key={opt} value={opt}>
      {opt}
    </MenuItem>
  ));
  const osOptionsList = osOptions.map((opt) => (
    <MenuItem key={opt} value={opt}>
      {opt}
    </MenuItem>
  ));
  const prikazKonfiguracija = konfiguracije.map((konf) => (
    <Prikaz konfiguracija = {konf} key = {konf.id}/>
  ));
  return (
    <Container className="form-container">
      <Paper elevation={3}>
        <FormTitle>Popunite zahteve</FormTitle>
        <form>
          <TextField
            type="number"
            label="Budzet"
            value={budzet}
            onChange={(event) => setBudzet(event.target.value)}
          />

          <label>Laptop:</label>
          <Checkbox checked={laptop} onChange={handleCheckLaptop} />
          <label>Svrha upotrebe:</label>
          <Select
            id="upotreba"
            value={upotreba}
            onChange={handleSelectChangeUpotreba}
          >
            {upotrebaOptionsList}
          </Select>
          <label>Preferirani proizvodjac GPU:</label>
          <Select
            id="prefGpu"
            value={prefGpu}
            onChange={handleSelectChangePrefGpu}
          >
            {prefGpuOptionsList}
          </Select>
          <label>Preferirani proizvodjac CPU:</label>
          <Select
            id="prefCpu"
            value={prefCpu}
            onChange={handleSelectChangePrefCpu}
          >
            {prefCpuOptionsList}
          </Select>
          <label>Da li ste koristili pre racunar:</label>
          <Checkbox checked={koristioPre} onChange={handleCheckKoristioPre} />
          <label>Ukoliko jeste, koji biste koristili:</label>
          <Select
            id="os"
            value={os}
            onChange={handleSelectChangeOs}
          >
            {osOptionsList}
          </Select>

          <Button variant="contained" color="primary" onClick={submitForm}>
            Posalji zahtev
          </Button>
        </form>
      </Paper>
      {prikazKonfiguracija}
    </Container>
  );
};

export default Zahtev;
