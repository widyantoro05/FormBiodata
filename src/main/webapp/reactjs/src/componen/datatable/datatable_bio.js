
import React, { Component } from 'react'


const $ = require('jquery')
$.Datatable = require('datatables.net')

export default class Tbl extends Component {

    componentDidMount() {
        console.log(this.el);
        this.$el = $(this.el)
        this.$el.DataTable(
            {
                data: this.props.data,
                columns: [
                    {
                        title: "Nama",
                        data: "nama"
                    },
                    {
                        title: "Alamat",
                        data: "alamat"
                    },
                    {
                        title: "NIK",
                        data: "nik"
                    },
                    {
                        title: "Tempat Lahir",
                        data: "tempatLahir"
                    },
                    {
                        title: "Tanggal Lahir",
                        data: "tanggalLahir"
                    },
                    {
                        title: "No HP",
                        data: "noHp"
                    },
                    {
                        title: "Action",
                        data: null,
                        render: function (data, type, row) {
                            return "<button className='btn-primary' onclick=formBiodata.setEditData('" + data.idPerson + "')>Edit</button>"
                        }
                    }
                ]
            }
        )
    }

    componentWillMount() {

    }

    render() {
        return <div className="card-body table-responsive">
            <table className="table table-striped table-bordered table-hover nowrap" width="100%" ref={el => this.el = el} >

            </table>
        </div>
    }

}
