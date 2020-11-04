import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Main extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/books">Books Section</Link></Button>
        </Container>
      </div>
    );
  }
}
export default Main;