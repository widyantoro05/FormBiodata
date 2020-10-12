import React from 'react';
import { Modal } from "react-bootstrap";
import {Table} from 'react-bootstrap';
import axios from 'axios';

const api = axios.create({
  baseURL : "http://localhost:1212"
})
class Form1 extends React.Component {
  state = {
    isOpen: false,
    person:[],
    post:[],
    formPost:{
      nama: '',
      nik:'',
      alamat:'',
      noHp: '',
      tanggalLahir:'',
      tempatLahir:''
    }
  };
  
  openModal = () => this.setState({ isOpen: true });
  closeModal = () => this.setState({ isOpen: false });

  constructor(){
    super();
    api.get('/person?_sort=idPerson&_order=desc').then(res =>{
       console.log(res.data)
    this.setState({person:res.data})
    });
    this.store = this.initialStore;
    // this.getPerson = this.getPerson.bind(this);
    this.submitForm=this.submitForm.bind(this);
    this.formChange=this.formChange.bind(this);
  }
  initialStore = {
    nik:'', nama:'', alamat:'', noHp:'', tempatLahir:'', tanggalLahir:''
  }
  resetForm = () =>{
    this.setState(() =>  this.initialStore)
  }
  submitForm = () => {
    this.postDataApi();
  }
  formChange = (event) => {
    // console.log('form change' ,event.target)
    let formPostnew ={...this.state.formPost};
    formPostnew[event.target.name]=event.target.value;
   
    this.setState({
      formPost:formPostnew
    }, ()=>{
      // console.log('value', this.state.formPost) 
    })
  }
  postDataApi = () =>{
    api.post('/person', this.state.formPost).then((res) =>{
      console.log(res);
    }, (err) =>{
       console.log('error:', err) 
    });
  }

  
  // getPerson = async () =>{
  //   let data = await api.get('/person').then( data =>{console.log (data.data)};
  //   this.setState({person: data.data});
  // }

  render(){
      return (
          <div className="content-wrapper">
            <section className="content-header">
              <div className="container-fluid">
                <div className="row mb">
                  <div className="col-sm">
                    <h1>Formulir Biodata</h1>
                  </div>
                  <div className="col-sm">
                    <ol className="breadcrumb float-sm-right">
                        <li className="breadcrumb-item"><a href="#">Home</a></li>
                        <li className="breadcrumb-item active">Formulir Biodata</li>
                    </ol>
                  </div>
                </div>
              </div>
            </section>
            <section className="content">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md">
                    <div className="card card-primary">
                      <div className="card-header">
                        <h3 className="card-title">Data Peserta</h3>
                      </div>
                      <div className="modal-footer justify-content-between" >
                        <button type="submit" id="tambah" className="float-right btn btn-success" onClick={this.openModal}>
                          Tambahkan Data
                        </button>
                      </div>
                      <div className="card-body table-responsive">
                        <Table striped bordered hover variant="">
                          <thead>
                            <tr>
                              <th>Nama</th>
                              <th>Alamat</th>
                              <th>NIK</th>
                              <th>No HandPhone</th>
                              <th>Tempat Lahir</th>
                              <th>Tanggal Lahir</th>
                            </tr>
                          </thead>
                          <tbody>
                            {
                              this.state.person.length === 0 ?
                              <tr align="center">
                                
                              </tr>:
                              this.state.person.map((pers)=>(
                                <tr key={pers.idPerson}>
                                  <td>{pers.nama}</td>
                                  <td>{pers.alamat}</td>
                                  <td>{pers.nik}</td>
                                  <td>{pers.noHp}</td>
                                  <td>{pers.tempatLahir}</td>
                                  <td>{pers.tanggalLahir}</td>
                                </tr>
                              ))
                            }
                          </tbody>
                        </Table>
                      </div>
                                
                      <Modal show={this.state.isOpen} onHide={this.closeModal}>
                          <div className="modal-content" style ={{width: '700px'}}>
                            <div className="modal-header">
                                <h4 className="modal-title">Form Biodata</h4>
                                <button aria-label="Close" className="close" data-dismiss="modal" type="button" onClick={this.closeModal}>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                              <div className="card-header">

                              </div>
                              <form id="form-biodata" role="form" >
                                  <input name="idPerson" id="idPerson" type="hidden"/>
                                  <input name="idBio" id="idBio" type="hidden"/>

                                  <div className="form-group">
                                      <label>NIK</label>
                                      <input className="form-control" id="nik" name="nik" 
                                      placeholder="masukan NIK" required onChange={this.formChange}
                                      autoComplete = "off" type="text"/>
                                  </div>
                                  <div className="form-group">
                                      <label>Nama Lengkap </label>
                                      <input className="form-control" id="nama" name="nama" placeholder="masukan nama" onChange={this.formChange} required type="text" />
                                  </div>
                                  <div className="form-group">
                                      <label htmlFor="alamat">Alamat</label>
                                      <textarea className="form-control" id="alamat" name="alamat" placeholder="masukan alamat" required onChange={this.formChange} type="text" rows="3"></textarea>
                                  </div>
                                  <div className="form-group">
                                      <label>No HP</label>
                                      <input className="form-control" id="noHp" name="noHp" placeholder="masukan noHP" onChange={this.formChange} required/>
                                  </div>
                                  <div className="form-group">
                                      <label htmlFor="tanggal">Tanggal Lahir</label>
                                      <input type="date" className="form-control" id ="tanggalLahir" name="tanggalLahir" onChange={this.formChange} required />
                                  </div>
                                  <div className="form-group">
                                      <label>Tempat Lahir</label>
                                      <input className="form-control" id="tempatLahir" name="tempatLahir" placeholder="masukan Tempat Lahir" required onChange={this.formChange} type="text" />
                                  </div>
                              </form>
                            </div>
                            <div className="modal-footer justify-content-between">
                              <button className="btn btn-default" data-dismiss="modal" type="button" onClick={this.closeModal}>Close</button>
                              <button className="btn btn-primary" id="btn-save-biodata" type="button" 
                                onClick={() => {
                                  this.submitForm();
                                  this.closeModal();
                                }}>Save</button>
                            </div>
                            
                          </div>  
                      
                      </Modal>
                    </div>
                  </div>
                </div>
              </div>
            </section>      
          </div>
      )
  }
}

export default Form1;
