'use strict';

app.directive('inputDirective', function() {
    function link(scope, elem, attrs, ngModel) {
        ngModel.$parsers.push(function(viewValue) {
            var reg = /^[^`~#$%\^&*()\-\\+={}|[\]\\:';"<>?,./]*$/;
            // if view values matches regexp, update model value
            if (viewValue.match(reg)) {
                return viewValue;
            }
            // keep the model value as it is
            var transformedValue = ngModel.$modelValue;
            ngModel.$setViewValue(transformedValue);
            ngModel.$render();
            return transformedValue;
        });
    }

    return {
        restrict: 'A',
        require: 'ngModel',
        link: link
    };
})

app.directive('emailDirective', function() {
    function link(scope, elem, attrs, ngModel) {
        ngModel.$parsers.push(function(viewValue) {
            var reg = /^[^`~#$%\^&*()\-\\+={}|[\]\\:';"<>?,/]*$/;
            // if view values matches regexp, update model value
            if (viewValue.match(reg)) {
                return viewValue;
            }
            // keep the model value as it is
            var transformedValue = ngModel.$modelValue;
            ngModel.$setViewValue(transformedValue);
            ngModel.$render();
            return transformedValue;
        });
    }

    return {
        restrict: 'A',
        require: 'ngModel',
        link: link
    };
})

.directive('onlyLettersInput',function onlyLettersInput() {
    return {
        require: 'ngModel',
        link: function(scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                var transformedInput = text.replace(/[^a-zA-Z]/g, '');

                if (transformedInput !== text) {
                    ngModelCtrl.$setViewValue(transformedInput);
                    ngModelCtrl.$render();
                }
                return transformedInput;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

