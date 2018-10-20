app.controller('signupCtrl',['$scope','UserService','AuthService','$localStorage','$sessionStorage','$http',
    function($scope,UserService,AuthService,$localStorage,$sessionStorage,$http){



        $scope.title = "Medical Api - Sign up Section";
        $scope.email = "";
        $scope.password = "";
        $scope.token="";
        $scope.loginStatus="";
        $scope.errorMessage = "";

        $scope.roles = [];


        $scope.storage = $localStorage;

        $http.get('/api/user/role-types')
            .then(function(response){

                if(response.data){
                    $scope.roles = response.data;

                }


                else
                    $scope.requestError = response.error;
            });

    }]);
