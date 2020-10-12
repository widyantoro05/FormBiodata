import React from 'react';

class NavbarLeft extends React.Component{
    render(){
        return (
            <aside className="main-sidebar sidebar-light-primary elevation-4">
                <a href="../../index3.html" className="brand-link">
                    <img src="/assets/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" className="brand-image img-circle elevation-3" />
                    <span className="brand-text font-weight-light">IND 2015</span>
                </a>
                <div className="sidebar">
                    <div className="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div className="image">
                            <img src="/assets/dist/img/dahyun.jpg" className="img-circle elevation-2" alt="User Image"/>
                        </div>
                        <div className="info">
                            <a href="#" className="d-block">Dahyun</a>
                        </div>
                    </div>

                    <nav className="mt-2">
                        <ul className="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <li className="nav-item has-treeview menu-open">
                                <a href="#" className="nav-link">
                                    <i className="nav-icon fas fa-edit"></i>
                                    <p>Pendataan<i className="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul id ="click" className="nav nav-treeview">
                                    <li className="nav-item">
                                        <a href="form1" className="nav-link">
                                            <i className="far fa-circle nav-icon"></i>
                                            <p>Formulir Biodata</p>
                                        </a>
                                    </li>
                                    <li className="nav-item">
                                        <a href="form2" className="nav-link">
                                            <i className="far fa-circle nav-icon"></i>
                                            <p>Formulir Pendidikan</p>
                                        </a>
                                    </li>
                                    <li className="nav-item">
                                        <a href="form3" className="nav-link">
                                            <i className="far fa-circle nav-icon"></i>
                                            <p>Cari Data</p>
                                        </a>
                                    </li>
                                    <li className="nav-item">
                                        <a href="form4.html" className="nav-link">
                                            <i className="far fa-circle nav-icon"></i>
                                            <p>Formulir4</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </aside>
            )
        }
}

export default NavbarLeft;