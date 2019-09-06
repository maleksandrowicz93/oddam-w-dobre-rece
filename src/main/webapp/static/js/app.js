document.addEventListener("DOMContentLoaded", function () {
    /**
     * HomePage - Help section
     */
    class Help {
        constructor($el) {
            this.$el = $el;
            this.$buttonsContainer = $el.querySelector(".help--buttons");
            this.$slidesContainers = $el.querySelectorAll(".help--slides");
            this.currentSlide = this.$buttonsContainer.querySelector(".active").parentElement.dataset.id;
            this.init();
        }

        init() {
            this.events();
        }

        events() {
            /**
             * Slide buttons
             */
            this.$buttonsContainer.addEventListener("click", e => {
                if(e.target.classList.contains("btn")
        )
            {
                this.changeSlide(e);
            }
        })
            ;

            /**
             * Pagination buttons
             */
            this.$el.addEventListener("click", e => {
                if(e
                .target.classList.contains("btn") && e.target.parentElement.parentElement.classList.contains("help--slides-pagination")
        )
            {
                this.changePage(e);
            }
        })
            ;
        }

        changeSlide(e) {
            e.preventDefault();
            const $btn = e.target;

            // Buttons Active class change
            [...this.$buttonsContainer.children
        ].
            forEach(btn => btn.firstElementChild.classList.remove("active")
        )
            ;
            $btn.classList.add("active");

            // Current slide
            this.currentSlide = $btn.parentElement.dataset.id;

            // Slides active class change
            this.$slidesContainers.forEach(el => {
                el.classList.remove("active");

            if (el.dataset.id === this.currentSlide) {
                el.classList.add("active");
            }
        })
            ;
        }

        /**
         * TODO: callback to page change event
         */
        changePage(e) {
            e.preventDefault();
            const page = e.target.dataset.page;

            console.log(page);
        }
    }

    const helpSection = document.querySelector(".help");
    if (helpSection !== null) {
        new Help(helpSection);
    }

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children
        ]
            ;
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
            li.dataset.value = el.value;
            li.innerText = el.innerText;

            if (i === 0) {
                // First clickable option
                this.current = document.createElement("div");
                this.current.innerText = el.innerText;
                this.dropdown.appendChild(this.current);
                this.valueInput.value = el.value;
                li.classList.add("selected");
            }

            this.ul.appendChild(li);
        })
            ;

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
            this.dropdown.classList.toggle("selecting");

            // Save new value only when clicked on li
            if (target.tagName === "LI") {
                this.valueInput.value = target.dataset.value;
                this.current.innerText = target.innerText;
            }
        })
            ;
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
})
    ;

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
    })
        ;
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions,
        ...
            $stepForms
        ]
            ;

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
            this.currentStep++;
            this.updateForm();
        })
            ;
        })
            ;

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
            this.currentStep--;
            this.updateForm();
        })
            ;
        })
            ;

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e)
        )
            ;
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

            if (slide.dataset.step == this.currentStep) {
                slide.classList.add("active");
            }
        })
            ;

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 6;
            this.$step.parentElement.hidden = this.currentStep >= 6;

            // TODO: get data from inputs and show them in summary

            var amountOfBags = document.getElementById("amountOfBags");
            var address = document.getElementById("address");
            var city = document.getElementById("city");
            var postcode = document.getElementById("postcode");
            var phone = document.getElementById("phone");
            var date = document.getElementById("date");
            var time = document.getElementById("time");
            var text = document.getElementById("text");

            var chosenProducts = [];
            var localization;
            var chosenHelp = [];
            var organizationName;
            var chosenOrganizationName;

            chosenProducts = createProductsArray();
            localization = prepareLocalizationFilter();
            chosenHelp = prepareHelpFilter();
            organizationName = prepareNameFilter();
            chosenOrganizationName = chooseOrganization();

            var productsAcceptButton = document.querySelector(".btn.next-step.first-slide");
            var conditionsOfSearchingOrganizationsAcceptButton = document.querySelector(".btn.next-step.third-slide");
            var organizationAcceptButton = document.querySelector(".btn.next-step.fourth-slide");
            var summaryButton = document.querySelector(".btn.next-step.fifth-slide");

            productsAcceptButton.addEventListener("click", createProductsArray);
            conditionsOfSearchingOrganizationsAcceptButton.addEventListener("click", prepareOrganizationFilters);
            organizationAcceptButton.addEventListener("click", chooseOrganization);
            summaryButton.addEventListener("click", displaySummary);

            function createProductsArray() {
                var checkboxBlocks = document.querySelectorAll(".form-group.form-group--checkbox.products");
                checkboxBlocks.forEach(putChosenProductsIntoArray);

                function putChosenProductsIntoArray(element) {
                    var checkbox = element.firstElementChild.firstElementChild;
                    if (checkbox.checked) {
                        var checkedProduct = checkbox.parentElement.lastElementChild;
                        var checkedProductName = checkedProduct.innerText;
                        chosenProducts.push(checkedProductName);
                    }
                }
                return chosenProducts;
            }

            function prepareOrganizationFilters() {
                prepareLocalizationFilter();
                prepareHelpFilter();
                prepareNameFilter();
            }

            function prepareLocalizationFilter() {
                var selectMenu = document.querySelector(".form-group.form-group--dropdown").firstElementChild;
                var selectedOption = selectMenu.lastElementChild;
                localization = selectedOption.value;
                return localization;
            }

            function prepareHelpFilter() {
                var checkboxBlocks = document.querySelectorAll(".form-group.form-group--checkbox.help-for");
                checkboxBlocks.forEach(putChosenProductsIntoArray);

                function putChosenProductsIntoArray(element) {
                    var checkbox = element.firstElementChild.firstElementChild;
                    if (checkbox.checked) {
                        var checkedHelp = checkbox.parentElement.lastElementChild;
                        var checkedHelpName = checkedHelp.innerText;
                        chosenHelp.push(checkedHelpName);
                    }
                }
                return chosenHelp;
            }

            function prepareNameFilter() {
                var organizationNameInput = document.getElementById("organization-name");
                organizationName = organizationNameInput.value;
                return organizationName;
            }

            function chooseOrganization() {
                var checkboxBlocks = document.querySelectorAll(".form-group.form-group--checkbox.choosing-organization");
                var i;
                for (i = 0; i < checkboxBlocks.length; i++) {
                    var checkbox = checkboxBlocks[i].firstElementChild.firstElementChild;
                    if (checkbox.checked) {
                        var checkedOrganization = checkbox.parentElement.lastElementChild.firstElementChild.firstElementChild;
                        chosenOrganizationName = checkedOrganization.innerText;
                        break;
                    }
                }
                return chosenOrganizationName;
            }

            function displaySummary() {

                var amountOfBagsInfo = document.getElementById("amountOfBags-info");
                var organizationInfo = document.getElementById("organization-info");
                var addressInfo = document.getElementById("address-info");
                var cityInfo = document.getElementById("city-info");
                var postcodeInfo = document.getElementById("postcode-info");
                var phoneInfo = document.getElementById("phone-info");
                var dateInfo = document.getElementById("date-info");
                var timeInfo = document.getElementById("time-info");
                var textInfo = document.getElementById("text-info");

                var bags = "";
                if (amountOfBags.value == 1) {
                    bags = "1 worek"
                } else if (amountOfBags.value <= 4) {
                    bags = amountOfBags.value + " worki";
                } else {
                    bags = amountOfBags.value + " worków";
                }
                amountOfBagsInfo.innerText = bags + " ubrań w dobrym stanie dla dzieci";

                organizationInfo.innerText = "Dla fundacji \"" + chosenOrganizationName + "\" w Warszawie";

                addressInfo.innerText = address.value;
                cityInfo.innerText = city.value;
                postcodeInfo.innerText = postcode.value;
                phoneInfo.innerText = phone.value;
                dateInfo.innerText = date.value;
                timeInfo.innerText = time.value;
                textInfo.innerText = text.value;
            }
        }

        /**
         * Submit form
         *
         * TODO: validation, send data to server
         */



        submit(e) {
            e.preventDefault();
            this.currentStep++;
            this.updateForm();
        }
    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});

$(document).ready(function(){

    function getParamMap() {
        var dataForm = $('#add-gift-form').serialize();
        var paramArray = dataForm.split('&');
        var paramMap = new Map();
        var i = 0;
        for (i; i < paramArray.length; i++) {
            var param = paramArray[i].split('=');
            var key = param[0];
            var value;
            if (paramMap.has(key)) {
                value = paramMap.get(key) + ", " + param[1];
            } else {
                value = param[1];
            }
            paramMap.set(key, value);
        }
        console.log(dataForm);
        return paramMap;
    }

    function sendDataToServer(paramMap) {
        $.post({
            url: 'http://localhost:8090/app',
            data: {
                products: paramMap.get("products%5B%5D"),
                bags: paramMap.get("bags"),
                localization: paramMap.get("localization"),
                help: paramMap.get("help%5B%5D"),
                organizationSearch: paramMap.get("organization_search"),
                organizationId: paramMap.get("organization"),
                address: paramMap.get("address"),
                city: paramMap.get("city"),
                postcode: paramMap.get("postcode"),
                phone: paramMap.get("phone"),
                date: paramMap.get("date"),
                time: paramMap.get("time"),
                moreInfo: paramMap.get("more_info")
            },
            datatype: 'json'
        }).done(function () {
            console.log("done");
            console.log(paramMap);
        }).fail(function () {
            console.log("fail")
        }).always(function () {
            console.log(paramMap)
        });
    }

    $('.btn.submit.sixth-slide').on('click', function () {
        var paramMap = getParamMap();
        sendDataToServer(paramMap);
    });

});
