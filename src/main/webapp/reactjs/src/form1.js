import React from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import NavigationBar from './componen/navbarleft';


function Form1(){
    return (
        <Container fluid>
            <Row>
                <Col sm={2}>sm=8</Col>
                <Col sm={10}>
                    <NavigationBar />
                </Col>
            </Row>
        </Container>
    )
}

export default Form1;