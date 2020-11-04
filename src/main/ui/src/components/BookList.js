import React, { Component } from 'react';
import { Button , ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class BookList extends Component {

  constructor(props) {
    super(props);
    this.state = {books: [], isLoading: true};
    this.checkin = this.checkin.bind(this);
    this.checkout = this.checkout.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('api/books')
      .then(response => response.json())
      .then(data => this.setState({books: data, isLoading: false}));
  }

  async checkin(id) {
    await fetch(`/api/book/checkin/${id}`, {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      this.props.history.push('/books')
    });
  }

  async checkout(id) {
    await fetch(`/api/book/checkout/${id}`, {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      this.props.history.push('/books')
    });
  }

  render() {
    const {books, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const bookList = books.map(book => {
      return <tr key={book.id}>
        <td style={{whiteSpace: 'nowrap'}}>{book.title}</td>
        <td>{book.author}</td>
        <td>{book.genre}</td>
        <td>{book.nbrPages}</td>
        <td>{book.available}</td>
        <td>
          <ButtonGroup>          	
            <Button size="sm" color="primary" tag={Link} to={"/books/" + book.id}>Edit</Button>&nbsp;
            <Button size="sm" color="success" onClick={() => this.checkin(book.id)}>CheckIn</Button>&nbsp;
            <Button size="sm" color="warning" onClick={() => this.checkout(book.id)}>CheckOut</Button>&nbsp;
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/books/new">Add book</Button>
          </div>
          <h3>The Book Collection</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="15%">Title</th>
              <th width="15%">Author</th>
              <th width="15%">Genre</th>
              <th width="15%"># Pages</th>
              <th>Available</th>
              <th width="10%">Actions</th>
            </tr>
            </thead>
            <tbody>
            {bookList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default BookList;