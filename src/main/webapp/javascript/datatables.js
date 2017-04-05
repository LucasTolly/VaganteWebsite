$(document).ready(function() {
    $('#datatable').DataTable( {
        "info":     false,
        "paging":   false,
        "columnDefs": [ {
            "targets": 2,
            "orderable": false
        }]
    } );
} );