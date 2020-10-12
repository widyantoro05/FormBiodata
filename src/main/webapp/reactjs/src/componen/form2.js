import React from 'react';
import {Modal} from 'react-bootstrap';

class Form2 extends React.Component{
    state = {
        isOpen: false
      };
    
      openModal = () => this.setState({ isOpen: true });
      closeModal = () => this.setState({ isOpen: false });
    
    render(){
        return (
            <div className="content-wrapper">
                <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb">
                        <div className="col-sm">
                            <h1>Formulir Pendidikan</h1>
                        </div>
                        <div className="col-sm">
                            <ol className="breadcrumb float-sm-right">
                                <li className="breadcrumb-item"><a href="#">Home</a></li>
                                <li className="breadcrumb-item active">Formulir Pendidikan</li>
                            </ol>
                        </div>
                        </div>
                    </div>
                </section>
                <div class="row">
                    <div class="col-md">
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Data Peserta</h3>
                            </div>
                            <div class="card-body">
                                <div class="col-row">
                                    <div class="card-footer">
                                        <div class="col-md-3">
                                            <input class="form-control" id="id" placeholder="masukan id anda" required data-parsley-type="number" type="number" />
                                        </div>
                                    </div>                  
                                    <div class="card-footer">
                                        <button type="submit" id="push" class="btn btn-success" onClick={this.openModal}>Tambahkan Jenjang Pendidikan</button>
                                    </div>
                                </div>
                            </div>
                        
                            <Modal show={this.state.isOpen} onHide={this.closeModal}>
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Form Biodata</h4>
                                            <button aria-label="Close" class="close" data-dismiss="modal" type="button" onClick={this.closeModal}>
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="card-header">
                        
                                            </div>
                                            <form id="form-biodata" role="form">
                                                <div class="form-group">
                                                    <label for="jenjang">Jenjang Pendidikan</label><br/>
                                                    <select class="form-control" name="jenjang" id="jenjang">
                                                        <option value="SD">SD</option>
                                                        <option value="SMP">SMP</option>
                                                        <option value="SMA">SMA</option>
                                                        <option value="S1">S1</option>
                                                        <option value="S2">S2</option>
                                                        <option value="S3">S3</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Nama Institusi </label>
                                                    <input class="form-control " id="institusi" name="institusi" placeholder="masukan institusi" required type="text" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Tahun Masuk</label>
                                                    <input class="form-control" id="tahunMasuk" name="tahunMasuk" placeholder="masukan tahun masuk" required data-parsley-type='digits' type="text" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Tahun Lulus</label>
                                                    <input class="form-control" id="tahunLulus" name="tahunLulus" placeholder="masukan tahun lulus" required data-parsley-type='digits' type="text" />
                                                </div>            
                                            </form>
                                        </div>
                                        <div class="modal-footer justify-content-between">
                                            <button class="btn btn-default" data-dismiss="modal" type="button" onClick={this.closeModal}>Close</button>
                                            <button class="btn btn-primary" id="btn-save-biodata2" type="button" onClick={this.closeModal}>Save</button>
                                        </div>
                                    </div>
                            </Modal>
                            <div class="card-body">
                                <div class="card-body">
                                    <table class="table table-bordered" id="tableBiodata2"
                                   ></table>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" id="submitdata" class="btn btn-success">Submit Data</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            )
        }
}

export default Form2;