'use strict';

app
    .controller('dashboardCtrl',['$scope','UserService','$localStorage','AuthService','$sessionStorage','$http',
        function($scope,UserService,$localStorage,AuthService,$sessionStorage,$http){


        var headers = {'Authorization':$localStorage.User.token};
        $http.get('/api/user/role',{headers:headers})
            .then(function(response){

                if(response.data){
                    $scope.userRole = response.data.role;
                    $localStorage.User.role = $scope.userRole;
                }


                else
                    $scope.requestError = response.error;
            });

        $localStorage.User.logged = true;
        UserService.User.loggedIn = true;

    $scope.title = "Menu Section - Angular JS";
    $scope.user = $localStorage.User;

        $scope.setGlobal = function(){
            UserService.User.email = $scope.email;
            UserService.User.password = $scope.password;
        };

        $scope.deleteData = function(){
            $localStorage.User.email='';
            $localStorage.User.password='';
            $localStorage.User.token = '';
            $localStorage.User.logged = false;
            $localStorage.User.role = '';
        };

        $scope.canView = function(){
            return $scope.userRole=='VISITOR' ? true : false;
        };

    }])

    .controller('medAllCtrl',
        ['$scope','$resource','medicineService','UserService',
        'AuthService','$localStorage','$sessionStorage','$http',
        function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

        $scope.title = "Medicines Section";
        $scope.segment = "View all medicines in the database";

            $scope.items = [];
            $scope.requestError = "";

            var headers = {'Authorization':$localStorage.User.token};
            $http.get('/api/medicines/list',{headers:headers})
                .then(function(response){

                    if(response.data)
                        $scope.items = response.data;

                    else
                        $scope.requestError = response.error;
                });

        $scope.sort = function(sortValue){
            $scope.sortKey = sortValue;
            $scope.reverse = !$scope.reverse;
        };

        $scope.itemModal = {
            id:'',
            key:'',
            name:'',
            description:'',
            price:'',
            valid:false,
            producer:''
        };

            $scope.setItemModal = function(id){
                $scope.itemModal = _.find($scope.items, {id:id});
            };

            $scope.getPrev = function(){
                var currentId = $scope.itemModal.id-1;

                $scope.itemModal = _.find($scope.items,{id:currentId});
            };

            $scope.getNext = function(){
                var currentId = $scope.itemModal.id+1;

                $scope.itemModal = _.find($scope.items,{id:currentId});
            };

    }])


    .controller('activeSubstanceCtrl',
        ['$scope','$resource','medicineService','UserService',
            'AuthService','$localStorage','$sessionStorage','$http',
            function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

                $scope.title = "Active Substances Section";
                $scope.segment = "View all active substances in the database";

                $scope.items = [];
                $scope.requestError = "";

                var headers = {'Authorization':$localStorage.User.token};
                $http.get('/api/active-substances/list',{headers:headers})
                    .then(function(response){

                        if(response.data)
                            $scope.items = response.data;

                        else
                            $scope.requestError = response.error;
                    });

                $scope.sort = function(sortValue){
                    $scope.sortKey = sortValue;
                    $scope.reverse = !$scope.reverse;
                };

                $scope.itemModal = {
                    id:'',
                    atcKey:'',
                    name:'',
                    description:''
                };

                $scope.setItemModal = function(id){
                    $scope.itemModal = _.find($scope.items, {id:id});
                };

                $scope.getPrev = function(){
                    var currentId = $scope.itemModal.id-1;

                    $scope.itemModal = _.find($scope.items,{id:currentId});
                };

                $scope.getNext = function(){
                    var currentId = $scope.itemModal.id+1;

                    $scope.itemModal = _.find($scope.items,{id:currentId});
                };

            }])

    .controller('sideEffectCtrl',
        ['$scope','$resource','medicineService','UserService',
            'AuthService','$localStorage','$sessionStorage','$http',
            function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

                $scope.title = "Side Effects Section";
                $scope.segment = "View all side effects that are recorded in database";

                $scope.items = [];
                $scope.sideEffects = [];
                $scope.requestError = "";

                var headers = {'Authorization':$localStorage.User.token};

                $http.get('/api/medicines/side-effects/types',{headers:headers})
                    .then(function(response){

                        if(response.data)
                            $scope.sideEffects = response.data;

                        else
                            $scope.requestError = response.error;
                    });

                $http.get('/api/side-effects/list',{headers:headers})
                    .then(function(response){

                        if(response.data){
                            $scope.items = response.data;
                        }


                        else
                            $scope.requestError = response.error;
                    });

                $scope.sort = function(sortValue){
                    $scope.sortKey = sortValue;
                    $scope.reverse = !$scope.reverse;
                };

                $scope.itemModal = {};


                $scope.setItemModal = function(id){

                    for(var i = 0; i<$scope.items.length; i++){
                        if($scope.items[i].sideEffect.id == id){
                            $scope.itemModal = $scope.items[i];
                        }
                    };
                };

                $scope.getPrev = function(){
                    var currentId = $scope.itemModal.sideEffect.id-1;

                    for(var i = 0; i<$scope.items.length; i++){
                        if($scope.items[i].sideEffect.id == currentId){
                            $scope.itemModal = $scope.items[i];
                        }
                    };
                };

                $scope.getNext = function(){
                    var currentId = $scope.itemModal.sideEffect.id+1;

                    for(var i = 0; i<$scope.items.length; i++){
                        if($scope.items[i].sideEffect.id == currentId){
                            $scope.itemModal = $scope.items[i];
                        }
                    };
                };

    }])
    .controller('medCreateCtrl',
        ['$scope','$resource','medicineService','UserService',
            'AuthService','$localStorage','$sessionStorage','$http',
            function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

                $scope.title = "Doctors Section - Create a new Medicine";
                $scope.segment = "Create new medicines to database";
                var headers = {'Authorization':$localStorage.User.token};

                $scope.searchTerm = "";

                $scope.medicine = {
                    id:'',
                    key:'',
                    name:'',
                    description:'',
                    price:'',
                    valid:true,
                    producer:''
                };

                $scope.medicineFound ={};

                $scope.activeSubstances = [];
                $scope.sideEffects = [];
                $scope.medicines = [];

                $scope.items = [];
                $scope.successMsg = "";
                $scope.errorMsg = "";

                $scope.fetchMedicines = function(){

                    $http.get("/api/medicines/list",{headers:headers}).then(
                        function(response){

                            if(response.data){
                                $scope.medicines = response.data;
                            }


                            else{
                                response.error = $scope.errorMsg;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.fetchSideEffects = function(){
                    $http.get("/api/side-effects/all",{headers:headers}).then(
                        function(response){

                            if(response.data)
                                $scope.sideEffects = response.data;

                            else{
                                response.error = $scope.errorMsg;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.fetchActiveSubstances = function(){
                    $http.get("/api/active-substances/list",{headers:headers}).then(
                        function(response){

                            if(response.data)
                                $scope.activeSubstances = response.data;

                            else{
                                response.error = $scope.errorMsg;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.getMedicine = function(){
                    if($scope.medicines.length!=0){

                        $scope.medicine = _.find($scope.medicines,{key:$scope.searchTerm},{name:$scope.searchTerm});
                    }
                };

                $scope.setMedicine = function(id){
                    $scope.medicine = _.find($scope.medicines, {id:id});
                };

                $scope.createMedicine = function(){

                    var Medicine = {
                        /**
                         * Set long ID to address serialization issues
                         */
                        id:99999999999999999,
                        key:'',
                        name:'',
                        description:'',
                        price:0.0,
                        isValid:true,
                        producer:''
                    }, headers = {'Authorization':$localStorage.User.token};

                    Medicine.key = $scope.medicine.key;
                    Medicine.name = $scope.medicine.name;
                    Medicine.description = $scope.medicine.description;
                    Medicine.price = $scope.medicine.price;
                    Medicine.producer = $scope.medicine.producer;

                    var json = angular.toJson(Medicine);

                        $http.post("/api/medicines/add",Medicine,{headers:headers})

                            .then(function(success){
                                $scope.emptyFields();
                                $scope.successMsg = 'Medicine was successfully created & registered in database';

                            },function(err){
                                $scope.errorMsg = 'There was a problem with your creation..';
                            });
                };

                $scope.emptyFields = function(){
                    $scope.medicine.id='';
                    $scope.medicine.key = '';
                    $scope.medicine.name = '';
                    $scope.medicine.description = '';
                    $scope.medicine.price = '';
                    $scope.medicine.valid = '';
                    $scope.medicine.producer = '';
                    $scope.errorMsg = "";
                    $scope.successMsg = "";
                };


                var createMedicineForm = document.getElementById('createMedicineForm').onsubmit = function(){
                    $scope.isMedicineRegistered();
                };

                $scope.isMedicineRegistered = function(){
                    $http.get("/api/medicines/key/"+$scope.medicine.key,{headers:headers})
                        .then(function(response){
                            if(response.data){
                                if(response.data.key==$scope.medicine.key){
                                    $scope.errorMsg = "This Medicine ID is already registered in Database. Please choose another ID";
                                }

                                else{
                                    $scope.createMedicine();
                                }

                            }
                            else{
                                alert('Could not connect to DB. Please try again later or contact your local admin');
                                return false;
                            }
                        })
                };


            }])

    .controller('medUpdateCtrl',
        ['$scope','$resource','medicineService','UserService',
            'AuthService','$localStorage','$sessionStorage','$http',
            function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

                var updateMedicineForm = document.getElementById('updateMedicineForm').onsubmit = function(){
                    $scope.updateMedicine();
                };

                $scope.title = "Doctors Section - Update Medicine";
                $scope.segment = "Find and update medicines";
                var headers = {'Authorization':$localStorage.User.token};

                $scope.searchTerm = "";


                $scope.medicine = {
                    id:'',
                    key:'',
                    name:'',
                    description:'',
                    price:'',
                    valid:'',
                    producer:'',
                    activeSubstances:[],
                    sideEffects:[]
                };

                $scope.activeSubstances = [];
                $scope.sideEffects = [];
                $scope.medicines = [];

                $scope.items = [];
                $scope.successMsg = "";
                $scope.errorMsg = "";


                $scope.fetchMedicines = function(){

                    $http.get("/api/medicines/list",{headers:headers}).then(
                        function(response){

                            if(response.data){
                                $scope.medicines = response.data;
                            }


                            else{
                                response.error = $scope.requestError;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.fetchSideEffects = function(){
                    $http.get("/api/side-effects/all",{headers:headers}).then(
                        function(response){

                            if(response.data)
                                $scope.sideEffects = response.data;

                            else{
                                response.error = $scope.requestError;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.fetchActiveSubstances = function(){
                    $http.get("/api/active-substances/list",{headers:headers}).then(
                        function(response){

                            if(response.data)
                                $scope.activeSubstances = response.data;

                            else{
                                response.error = $scope.requestError;
                                alert("Connection to db failed... Please try again later or contact your local admin");
                            }
                        }
                    );
                };

                $scope.getMedicine = function(){
                    if($scope.medicines.length!=0){

                        $scope.medicine = _.find($scope.medicines,{key:$scope.searchTerm},{name:$scope.searchTerm});
                    }
                };

                $scope.setMedicine = function(id){
                    $scope.medicine = _.find($scope.medicines, {id:id});
                };

                $scope.updateMedicine = function(){

                    var Medicine = {
                        id:'',
                        key:'',
                        name:'',
                        description:'',
                        price:0.0,
                        isValid:0,
                        producer:''
                    }, headers = {'Authorization':$localStorage.User.token};


                    Medicine.id = $scope.medicine.id;
                    Medicine.key = $scope.medicine.key;
                    Medicine.name = $scope.medicine.name;
                    Medicine.description = $scope.medicine.description;
                    Medicine.price = $scope.medicine.price;
                    Medicine.isValid = $scope.medicine.valid;
                    Medicine.producer = $scope.medicine.producer;
                    //var json = angular.toJson(Medicine);
                    var json = angular.toJson($scope.medicine);

                    $http.put("/api/medicines/id/"+$scope.medicine.id,json,{headers:headers})
                        .then(function(success){
                            $scope.emptyFields();
                            $scope.successMsg = 'Medicine was successfully updated in database';

                        },function(err){
                            $scope.errorMsg = 'There was a problem with your updating..';
                        });
                };


                $scope.info = function(){
                };

                $scope.emptyFields = function(){
                    $scope.medicine.id='';
                    $scope.medicine.key = '';
                    $scope.medicine.name = '';
                    $scope.medicine.description = '';
                    $scope.medicine.price = '';
                    $scope.medicine.valid = '';
                    $scope.medicine.producer = '';
                    $scope.successMsg = "";
                    $scope.errorMsg = "";
                };
            }])

    .controller('aboutCtrl',['$scope','UserService','$localStorage','AuthService','$sessionStorage','$http',
        function($scope,UserService,$localStorage,AuthService,$sessionStorage,$http){
            $scope.title = "About this Project";
            $scope.segment = "Course : Medical Informatics";
        }])

    .controller('apiDocCtrl',
        ['$scope','$resource','medicineService','UserService',
            'AuthService','$localStorage','$sessionStorage','$http',
            function($scope,$resource,medicineService,UserService,AuthService,$localStorage,$sessionStorage,$http){

        $scope.title = "Medical Api - Rest";
        $scope.segment = "Rest Api Exposed Endpoints & Request Payloads";
        var path = '../resources/img/';

        $scope.rest = {
            Get:[
                {url:'/api/medicines/all',img:path+'medicines_list.jpg'},
                {url:'/api/medicines/side-effects/types',img:path+'side_effects.jpg'},
                {url:'/api/medicines/side-effects/list',img:path + 'side_effects_medicines.jpg'},
                {url:'/api/medicines/active-substances/list',img:path + 'active_substances.jpg'}
            ],

            Put:[{url:'/api/medicines/update',img:path + 'put.jpg'}],

            Post:[{url:'/api/medicines/create',img:path + 'post.jpg'}],
            Rest:[{url:'/api',img:path+'rest_endpoints.jpg'}]
        };


    }]);


