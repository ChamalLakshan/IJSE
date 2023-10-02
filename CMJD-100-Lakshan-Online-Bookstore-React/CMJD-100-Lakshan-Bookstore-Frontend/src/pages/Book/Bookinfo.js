import { useEffect, useState } from "react";
import { Button, Container, FloatingLabel, Form, Modal, Table } from "react-bootstrap";
import { getRequest, postRequest } from "../../services/ApiService";

const Bookinfo = () => {
    const [bookname, setBookname] = useState(null);

    const [NoOfbooks, setNoofbooks] = useState("");
    const [price, setPrice] = useState(0);
    const [authorname, setAuthorname] = useState(0);
    const[bookdetails, setBookdetails]=useState(0);

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    useEffect(() => {

        const getAllItems = async () => {
            const response = await getRequest("/books");
            setItems(response.data);
        }

        getAllItems();

    }, []);

    const addBookinfo = async (event) => {
        event.preventDefault();

        const data = {
            "bookname": itemName,
            "noofbooks": qty,
            "price": price,
            "authorname":authorname,
            "bookdetails":bookdetails,
        }

        const response = await postRequest("/books",data);

        if(response && response.status === 201) {
            setBookname([...items,response.data]);
            setNoofbooks("");
            setAuthorname(0);
            setPrice(0);
            setBookdetails(0);
            handleClose();
        } else {
            
        }
    }

    return (
        <>
            <Container>
                <Table responsive>
                    <thead>
                        <tr>
                            <th>BookId</th>
                            <th>UserId</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>No of Books</th>
                            <th>Author Name</th>
                            <th>Book Details</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {books && books.map(book => {
                            return (
                                <tr>
                                    <td>{book.id}</td>
                                    <td>{book.name}</td>
                                    <td>{book.price}</td>
                                    <td>{book.NoOfbooks}</td>
                                    <td>{book.authorname}</td>
                                    <td>{book.bookdetails}</td>
                                    <td>
                                        <Button variant="secondary" size="sm">Edit</Button>&nbsp;
                                        <Button variant="danger" size="sm">Delete</Button>
                                        <Button variant="secondary" size="sm" >Update</Button>
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </Table>
                <div className="text-end">
                    <Button variant="primary" onClick={handleShow}>Add Book</Button>
                </div>
            </Container>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Book</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={addBook}>
                        <FloatingLabel id="bookName" label="Name of the Book" className="mb-3">
                            <Form.Control placeholder="Name of the Book" value={itemName} onChange={(event) => {
                                setBookname(event.target.value)
                            }} />
                        </FloatingLabel>

                        <FloatingLabel id="bookPrice" label="Price" className="mb-3">
                            <Form.Control placeholder="Price" value={price} onChange={(event) => {
                                setPrice(event.target.value);
                            }} />
                        </FloatingLabel>

                        <FloatingLabel id="noOfBooks" label="Stock Books" className="mb-3">
                            <Form.Control type="number" placeholder="Stock Books" value={qty} onChange={(event) => {
                                setNoofbooks(event.target.value);
                            }}/>
                        </FloatingLabel>
                        <FloatingLabel id="authorName" label="Author Name" className="mb-3">
                            <Form.Control placeholder="authorName" value={price} onChange={(event) => {
                                setAuthorname(event.target.value);
                            }} />
                        </FloatingLabel>
                        <FloatingLabel id="bookDetails" label="Details" className="mb-3">
                            <Form.Control placeholder="Details" value={price} onChange={(event) => {
                                setBookdetails(event.target.value);
                            }} />
                        </FloatingLabel>

                        <Button type="submit" variant="primary">Save</Button>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    )
}

export default Bookinfo;