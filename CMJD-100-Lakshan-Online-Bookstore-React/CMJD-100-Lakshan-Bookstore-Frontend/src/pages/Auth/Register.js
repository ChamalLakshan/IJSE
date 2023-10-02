import { useState } from 'react';
import { Button, Container, FloatingLabel, Form } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Register = () => {

    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const[mobilenumber,setMobilenumber]=useState("");
    const[role ,setRole]=useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const [registerEnabled, setRegisterEnabled] = useState(false);

    const handleName = (event) => {
        setName(event.target.value);

        if (name.length <= 5) {
            setRegisterEnabled(false);
        } else {
            setRegisterEnabled(true);
        }
    }

    const handlePassword = (event) => {
        setPassword(event.target.value);

        if (password.length < 6) {
            setRegisterEnabled(false);
        } else {
            setRegisterEnabled(true);
        }
    }

    const handleEmail = (event) => {
        setEmail(event.target.value);
        const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;

        if (email !== "" && regex.test(email)) {
            setRegisterEnabled(true);
        } else {
            setRegisterEnabled(false);
        }
    }
    const handleMobilenumber = (event) => {
        setMobilenumber(event.target.value);

        if (name.length <= 5) {
            setRegisterEnabled(false);
        } else {
            setRegisterEnabled(true);
        }
    }
    const handleRole = (event) => {
        setRole(event.target.value);

        if (name.length <= 5) {
            setRegisterEnabled(false);
        } else {
            setRegisterEnabled(true);
        }
    }

    const handleRegister = async (event) => {
        event.preventDefault();

        const data = {
            'name': name,
            'password': password,
            'email': email,
            'mobilenumber':mobilenumber,
            'role':role
        };

        try {
            const response = await axios.post('http://localhost:8081/auth/register', data);
            navigate("/login");
            setError("");
        } catch (error) {
            setError(error.response.data.message);
        }


    }

    return (
        <>
            <Container>
                <div className='login-box shadow-sm rounded'>
                    <div className='text-center mb-4'>
                        <h1>User Register</h1>
                    </div>

                    <Form onSubmit={handleRegister}>
                        <FloatingLabel controlId='name' label="Select a Name" className='mb-3'>
                            <Form.Control placeholder='Select a Name' value={name} onChange={handleName} />
                        </FloatingLabel>

                        <FloatingLabel controlId="password" label="Select a Password" className='mb-3'>
                            <Form.Control type="password" placeholder='Enter Password' value={password} onChange={handlePassword} />
                        </FloatingLabel>

                        <FloatingLabel controlId="email" label="Enter your Email Address" className='mb-3'>
                            <Form.Control type="email" placeholder='Enter your Email Address' value={email} onChange={handleEmail} />
                        </FloatingLabel>

                        <FloatingLabel controlId='mobilenumber' label="Select a Mobile Number" className='mb-3'>
                            <Form.Control placeholder='Select a Mobile Number'value={name} onChange={handleMobilenumber} />
                        </FloatingLabel>

                        <FloatingLabel controlId='role' label="Select a Role" className='mb-3'>
                            <Form.Control placeholder='Select a Role' value={name} onChange={handleRole} />
                        </FloatingLabel>

                        {error &&
                            <div className='text-danger mb-3'>
                                {error}
                            </div>
                        }

                        <div className='text-end'>
                            <Button type="submit" variant="primary" disabled={!registerEnabled}>Register</Button>
                        </div>
                    </Form>


                </div>
            </Container>
        </>
    )
}

export default Register;