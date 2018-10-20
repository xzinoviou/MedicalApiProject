'use strict';

app.config(['$locationProvider',function($locationProvider){
    $locationProvider.hashPrefix('');
}])


.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){

    //$urlRouterProvider.otherwise('dashboard');

    $stateProvider
        .state('about',{
            url:'/about',
            templateUrl:'views/about.html',
            controller:'aboutCtrl'
        })

        .state('medicineAll',{
            url:'/medicines/view',
            templateUrl:'views/medicineAll.html',
            controller:'medAllCtrl'
        })

        .state('activeSubstances',{
            url:'/active-substances/view',
            templateUrl:'views/activeSubstances.html',
            controller:'activeSubstanceCtrl'
        })

        .state('sideEffects',{
            url:'/side-effects/view',
            templateUrl:'views/sideEffects.html',
            controller:'sideEffectCtrl'
        })

        .state('medicineUpdate',{
            url:'/medicines/update',
            templateUrl:'views/medicineUpdate.html',
            controller:'medUpdateCtrl'
        })

        .state('medicineCreate',{
            url:'/medicines/create',
            templateUrl:'views/medicineCreate.html',
            controller:'medCreateCtrl'
        })

        .state('apiDoc',{
            url:'/api-doc',
            templateUrl:'views/apiDoc.html',
            controller:'apiDocCtrl'
        })

        .state('apiDoc.get',{
            url:'/http-requests/get',
            templateUrl:'views/get.html',
            controller:'apiDocCtrl'
        })
        .state('apiDoc.put',{
            url:'/http-requests/put',
            templateUrl:'views/put.html',
            controller:'apiDocCtrl'
        })
        .state('apiDoc.post',{
            url:'/http-requests/post',
            templateUrl:'views/post.html',
            controller:'apiDocCtrl'
        })
        .state('apiDoc.endpoints',{
            url:'/http-requests/end-points',
            templateUrl:'views/endpoints.html',
            controller:'apiDocCtrl'
        });

}]);