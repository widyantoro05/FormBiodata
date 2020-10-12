import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import NavbarTop from './componen/navbartop';
import NavbarLeft from './componen/navbarleft';
import Form1 from './componen/form1';
import Form2 from './componen/form2';
import Form3 from './componen/form3';


function Base(){
    return (
        <Router>
            <div className="wrapper">
                <NavbarTop/>
                <NavbarLeft/>
                <Switch>
                    <Route path="/form1" exact component={Form1}/>
                    
                    <Route path="/form2" exact component={Form2}/>
                    
                    <Route path="/form3" exact component={Form3}/>
                </Switch>
            </div>
        </Router>
    )
}

export default Base;