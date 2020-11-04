import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Main from './Main';
import BookList from './components/BookList';
import BookEdit from './components/BookEdit';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Main}/>
          <Route path='/books' exact={true} component={BookList}/>
          <Route path='/books/:id' exact={true} component={BookEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
