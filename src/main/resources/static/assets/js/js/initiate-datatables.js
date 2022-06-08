// Initiate datatables in roles, tables, users page
(function() {
    'use strict';
    
    $('#dataTables-example').DataTable({
        responsive: true,
        paging: true,
        pageLength: 5,
        lengthChange: false,
        serverSide: true,
        searching: true,
        ordering: true
    });
})();