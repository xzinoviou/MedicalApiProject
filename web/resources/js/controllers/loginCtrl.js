app.controller('loginCtrl',['$scope','UserService','AuthService','$localStorage','$sessionStorage',
    function($scope,UserService,AuthService,$localStorage,$sessionStorage){


        $scope.title = "Medical Api - Login";
        $scope.email = "";
        $scope.password = "";
        $scope.token="";
        $scope.loginStatus="";

        $scope.storage = $localStorage;


        $scope.storeData = function(){

            if($scope.loginStatus!='Wrong credentials'){

                $scope.token = AuthService.createToken($scope.email,$scope.password);

                $localStorage.User ={
                    email : $scope.email,
                    password:$scope.password,
                    token : $scope.token,
                    role:'',
                    logged:false
                };

                UserService.User.email = $scope.email;
                UserService.User.password = $scope.password;
                UserService.User.token = $scope.token;
                UserService.User.loggedIn = false;
            }

        };

    }]);