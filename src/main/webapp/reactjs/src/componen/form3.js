import React from 'react';

class Form3 extends React.Component{
  
    render(){
        return (
            <div className="content-wrapper">
                <section className="content-header">
              <div className="container-fluid">
                <div className="row mb">
                  <div className="col-sm">
                    <h1>Cari Data</h1>
                  </div>
                  <div className="col-sm">
                    <ol className="breadcrumb float-sm-right">
                        <li className="breadcrumb-item"><a href="#">Home</a></li>
                        <li className="breadcrumb-item active">Cari data menggunakan NIK</li>
                    </ol>
                  </div>
                </div>
              </div>
            </section>
                <form role="form" id="myForm">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md">
                                <div class="card card-primary">
                                    <div class="card-header">
                                        <h3 class="card-title">Data Peserta</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <input class="form-control" id="idnik" placeholder="cari dari nik" required type="text" />
                                            </div>
                                            <div class="col-md-3">
                                                <button type="button" id="cari" class="btn btn-success">Cari</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="card-body">
                                            <table class="table table-striped table-bordered table-hover nowrap" id="tableBiodata3">

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                </form>
            </div>
            )
        }
}

export default Form3;