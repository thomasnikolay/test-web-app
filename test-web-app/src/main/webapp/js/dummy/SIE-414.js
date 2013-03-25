function checkedAll(frm1, selectorID) {
    var children = document.getElementById(frm1).getElementsByTagName("input"), checked = (document.getElementById(selectorID).checked == true), i;
    for (i = children.length - 1; i >= 0; i--) {
        if (children[i].type == "checkbox") {
            children[i].checked = checked
        }
    }
}
function setCharCount(inputId, idToSet) {
    var inputElement = document.getElementById(inputId);
    if (inputElement.value.length > 128) {
        inputElement.value = inputElement.value.substring(0, 128)
    }
    document.getElementById(idToSet).innerHTML = inputElement.value.length
}
function selectAllCheckboxLink(targetname, ids) {
    var sel = document.getElementsByName(targetname)[0], i;
    for (i = ids.length - 1; i >= 0; i--) {
        document.getElementsByName(ids[i])[0].checked = !sel.checked
    }
}
function selectAllCheckbox(target, ids) {
    for (var i = ids.length - 1; i >= 0; i--) {
        document.getElementsByName(ids[i])[0].checked = target.checked
    }
}
function selectAll(target, singles) {
    var sel = target.checked, form = target, i, inp;
    while (form.nodeName.toLowerCase() != "form") {
        form = form.parentNode
    }
    for (i = 0; i < singles.length; i++) {
        inp = find(form, "form['" + singles[i] + "']");
        if (inp != null) {
            inp.checked = sel
        }
    }
}
function selectSingle(target, group) {
    var form, selectAll;
    if (!target.checked) {
        form = target;
        while (form.nodeName.toLowerCase() != "form") {
            form = form.parentNode
        }
        selectAll = find(form, "form.selectAll" + group);
        if (selectAll != null) {
            selectAll.checked = false
        }
    }
}
function find(node, name) {
    if (node.nodeType != 1) {
        return null
    }
    if (node.name == name) {
        return node
    }
    var child, res;
    for (child = node.firstChild; child != null; child = child.nextSibling) {
        res = find(child, name);
        if (res != null) {
            return res
        }
    }
    return null
}
var onLoadFun = function(event) {
    var click = function(parent) {
        var search = [parent], node, child;
        while (search.length > 0) {
            node = search.pop();
            if (node.nodeType == Node.ELEMENT_NODE) {
                if ((node.nodeName + "").toLowerCase() == "a" && node.href) {
                    window.location.href = node.href;
                    return
                }
                for (child = node.firstChild; child != null; child = child.nextSibling) {
                    search.push(child)
                }
            }
        }
    };
    var nodes = document.querySelectorAll(".boxlink"), i;
    for (i = nodes.length - 1; i >= 0; i--) {
        (function() {
            var node = nodes[i], nodeFun = function(event) {
                click(node)
            };
            if (node.addEventListener) {
                node.addEventListener("click", nodeFun, true)
            } else {
                if (window.attachEvent) {
                    node.attachEvent("onclick", nodeFun, true)
                } else {
                    node.onclick = fun
                }
            }
        })()
    }
};
if (window.addEventListener) {
    window.addEventListener("load", onLoadFun, false)
} else {
    if (window.attachEvent) {
        window.attachEvent("onload", onLoadFun, false)
    } else {
        el.onload = fun
    }
}
function openBirthDate(resField, hiddenYearField, hiddenMonthField, hiddenDayField, firstDateYear, lastDateYear, lang) {
    var days = {}, years = {}, months = {1: "Jan", 2: "Feb", 3: "Mar", 4: "Apr", 5: (lang == "de-DE") ? "Mai" : "May", 6: "Jun", 7: "Jul", 8: "Aug", 9: "Sep", 10: (lang == "de-DE") ? "Okt" : "Oct", 11: "Nov", 12: (lang == "de-DE") ? "Dez" : "Dec"}, hiddenDayInputField, hiddenMonthInputField, hiddenYearInputField, i, fieldToUpdate, results;
    for (i = 1; i < 32; i++) {
        days[i] = i
    }
    for (i = lastDateYear; i <= firstDateYear; i++) {
        years[i] = i
    }
    hiddenDayInputField = document.getElementById(hiddenDayField);
    hiddenMonthInputField = document.getElementById(hiddenMonthField);
    hiddenYearInputField = document.getElementById(hiddenYearField);
    if (lang == "de-DE") {
        SpinningWheel.addSlot(days, "right", hiddenDayInputField.value);
        SpinningWheel.addSlot(months, "", hiddenMonthInputField.value);
        SpinningWheel.addSlot(years, "right", hiddenYearInputField.value)
    } else {
        SpinningWheel.addSlot(months, "", hiddenMonthInputField.value);
        SpinningWheel.addSlot(days, "right", hiddenDayInputField.value);
        SpinningWheel.addSlot(years, "right", hiddenYearInputField.value)
    }
    SpinningWheel.setDoneAction(function() {
        results = SpinningWheel.getSelectedValues();
        fieldToUpdate = document.getElementById(resField);
        if (lang == "de-DE") {
            fieldToUpdate.innerHTML = results.keys.join(".");
            hiddenDayInputField.value = results.keys[0];
            hiddenMonthInputField.value = results.keys[1];
            hiddenYearInputField.value = results.keys[2]
        } else {
            fieldToUpdate.innerHTML = results.keys.join("/");
            hiddenDayInputField.value = results.keys[1];
            hiddenMonthInputField.value = results.keys[0];
            hiddenYearInputField.value = results.keys[2]
        }
    });
    SpinningWheel.setCancelAction(cancel);
    SpinningWheel.open()
}
function cancel() {
    SpinningWheel.close()
}
function orientationImage(id, src, format) {
    try {
        Netbiscuits.screen.resizeEvent.add(function() {
            document.getElementById(id).src = src + ((nbdevice.orientation === "landscape") ? "_l." : ".") + format
        })
    } catch (e) {
    }
}
function orientationPFIndex(id, servletPath, index) {
    try {
        Netbiscuits.screen.resizeEvent.add(function() {
            var requestString = "/" + servletPath + "?landscape=" + (nbdevice.orientation === "landscape") + "&index=" + index;
            Netbiscuits.core.ajax.getRemoteBiscuit(id, requestString, id, 1)
        })
    } catch (e) {
    }
}
function orientationTeaserSection(id) {
    try {
        netbiscuits.screen.resizeEvent.add(function() {
            var calcwidth = (screen.width - 48), calcheight = (screen.height - 48);
            document.getElementById(id).style.width = (nbdevice.orientation === "landscape" ? Math.max(calcwidth, calcheight) : Math.min(calcwidth, calcheight)) + "px"
        })
    } catch (e) {
    }
}
function orientationGallery(id) {
    var fun = function() {
        var show = ((nbdevice.orientation === "landscape") && (id.substr(-1) === "1")) || ((nbdevice.orientation !== "landscape") && (id.substr(-1) === "0"));
        if (show) {
            Netbiscuits.core.css.show(id)
        } else {
            Netbiscuits.core.css.hide(id)
        }
    };
    fun();
    try {
        netbiscuits.screen.resizeEvent.add(fun)
    } catch (e) {
    }
}
function pickItemFromDownDown(dropDownID, targetDropDownID, servletPath, key) {
    var dropDown = document.getElementById(dropDownID), value = dropDown.options[dropDown.selectedIndex].value, requestString = "/" + servletPath + "?" + key + "=" + value;
    Netbiscuits.core.ajax.getRemoteBiscuit(targetDropDownID, requestString, targetDropDownID, 1)
}
function autoSuggest(elem, containerID, formname, inputID, proxyPath) {
    var keyword = elem.value, container, requestURL;
    if (keyword.length > 2) {
        Netbiscuits.core.css.show("'" + containerID + "'");
        requestURL = proxyPath + "/autosuggest.htm?" + "suggestInput=" + encodeURIComponent(keyword) + "&formname=" + encodeURIComponent(formname) + "&containerID=" + encodeURIComponent(containerID) + "&inputID=" + encodeURIComponent(inputID);
        Netbiscuits.core.ajax.getRemoteBiscuit(containerID, requestURL, "suggestContainer", "1");
        container = document.getElementById(containerID);
        container.style.left = (elem.offsetLeft) + "px";
        container.style.width = (elem.offsetWidth - 2) + "px";
        container.style.top = (elem.offsetTop + elem.offsetHeight + elem.offsetParent.offsetTop) + "px";
        container.style.display = "block"
    } else {
        closeSuggestionBox(containerID)
    }
}
function hideSuggestionBox(containerID) {
    window.setTimeout("closeSuggestionBox('" + containerID + "')", 100)
}
function closeSuggestionBox(containerID) {
    var container = document.getElementById(containerID);
    if (container.style.display == "block") {
        container.innerHTML = "";
        container.style.display = "none";
        Netbiscuits.core.css.hide("'" + containerID + "'")
    }
}
function calClick(e, icsHref) {
    e.preventDefault();
    e.cancelBubble = true;
    if (e.stopPropagation) {
        e.stopPropagation()
    }
    window.location.href = icsHref
}
function calClickBB(e, summary, startTime, endTime, location, note) {
    e.cancelBubble = true;
    if (e.stopPropagation) {
        e.stopPropagation()
    }
    bbAppointment(summary, startTime, endTime, location, note)
}
function bbAppointment(summary, startTime, endTime, location, note) {
    var startDate = startTime.split("-"), appointmentInfo = {"summary": summary, "location": location, "allDay": true, "start": new Date(parseInt(startDate[0], 10), (parseInt(startDate[1], 10) - 1), (parseInt(startDate[2], 10) + 1)), "freeBusy": 1, "note": note}, endDate;
    if (endTime !== "") {
        endDate = endTime.split("-");
        appointmentInfo["end"] = new Date(parseInt(endDate[0], 10), (parseInt(endDate[1], 10) - 1), (parseInt(endDate[2], 10) + 1))
    }
    try {
        blackberry.launch.newAppointment(appointmentInfo)
    } catch (err) {
        alert(err)
    }
}
var headerMenu = (function() {
    var menuopentime = 500, ignoreCloseEvt = "";
    function slideInit(elem) {
        elem.style.height = "0px";
        elem.style.overflow = "hidden";
        elem.style.zIndex = "500";
        elem.style.transition = "height " + menuopentime + "ms linear";
        elem.style.WebkitTransition = "height " + menuopentime + "ms linear";
        elem.style.OTransition = "height " + menuopentime + "ms linear";
        elem.style.MozTransition = "height " + menuopentime + "ms linear"
    }
    function slideDown(elem) {
        Netbiscuits.core.css.show(elem.id);
        elem.style.width = (elem.clientWidth - 28) + "px";
        elem.style.position = "absolute";
        setTimeout(function() {
            var height = 20, i;
            for (i = elem.childNodes.length - 1; i >= 0; i--) {
                if (elem.childNodes[i].offsetHeight != null && elem.childNodes[i].offsetHeight > 0) {
                    height += elem.childNodes[i].offsetHeight
                }
            }
            elem.style.height = (height > 50) ? height + "px" : "100%";
            setTimeout(function() {
                if (elem.style.height == height + "px") {
                    elem.style.position = "relative";
                    elem.style.width = "auto"
                }
            }, menuopentime)
        }, 10)
    }
    function slideUp(elem) {
        elem.style.height = "0px";
        setTimeout(function() {
            if (elem.style.height == "0px") {
                Netbiscuits.core.css.hide(elem.id);
                elem.style.position = "relative";
                elem.style.width = "auto"
            }
        }, menuopentime * 2)
    }
    function toggleMenu(showId, allIds) {
        var btnElement = document.getElementById(showId + "btn"), i, naviconelement;
        ignoreCloseEvt = showId;
        if (btnElement) {
            naviconelement = btnElement.getElementsByTagName("span")[0];
            if (Netbiscuits.core.css.hasClass(btnElement, "active")) {
                showId = null
            }
        }
        if (naviconelement) {
            if (naviconelement.className.indexOf("navicon2_active") > -1) {
                Netbiscuits.core.css.swapClass(naviconelement.id, "navicon2_active", "navicon2")
            } else {
                if (naviconelement.className.indexOf("navicon_active") > -1) {
                    Netbiscuits.core.css.swapClass(naviconelement.id, "navicon_active", "navicon")
                } else {
                    if (naviconelement.className.indexOf("navicon2") > -1) {
                        Netbiscuits.core.css.swapClass(naviconelement.id, "navicon2", "navicon2_active")
                    } else {
                        if (naviconelement.className.indexOf("navicon") > -1) {
                            Netbiscuits.core.css.swapClass(naviconelement.id, "navicon", "navicon_active")
                        }
                    }
                }
            }
        }
        if (allIds) {
            for (i = 0; i < allIds.length; i++) {
                if (allIds[i] != showId) {
                    slideUp(document.getElementById(allIds[i] + "_open"));
                    Netbiscuits.core.css.show((allIds[i] + "down"));
                    Netbiscuits.core.css.hide((allIds[i] + "active"));
                    Netbiscuits.core.css.removeClass((allIds[i] + "btn"), "active");
                    var otherbtn = document.getElementById(allIds[i] + "btn").getElementsByTagName("span")[0];
                    if (otherbtn && otherbtn.className.indexOf("_active") > -1) {
                        otherbtn.className = otherbtn.className.replace("_active", "")
                    }
                }
            }
        }
        if (showId) {
            slideDown(document.getElementById(showId + "_open"));
            Netbiscuits.core.css.hide(showId + "down");
            Netbiscuits.core.css.show(showId + "active");
            Netbiscuits.core.css.addClass((showId + "btn"), "active")
        }
        setTimeout(function() {
            ignoreCloseEvt = null
        }, 500)
    }
    function registerMenuEvents(ids) {
        var i, fun;
        fun = function(e) {
            if (ignoreCloseEvt == null) {
                toggleMenu(null, ids)
            }
        };
        if (document.body.addEventListener) {
            document.body.addEventListener("click", fun, false)
        } else {
            if (document.body.attachEvent) {
                document.body.attachEvent("onclick", fun, false)
            } else {
                el.onclick = fun
            }
        }
        for (i = ids.length - 1; i >= 0; i--) {
            slideInit(document.getElementById(ids[i] + "_open"))
        }
    }
    return{init: function() {
            var menuIdList = document.getElementById("jsRegisterMenuEvents").firstChild.innerHTML;
            registerMenuEvents(JSON.parse(menuIdList))
        }, toggleMenu: function(showId, allIds) {
            toggleMenu(showId, allIds)
        }, ignoreClose: function(preventDefault) {
            ignoreCloseEvt = true
            if (preventDefault) {
                event.preventDefault()
            }            
        }, accordionSlide: function(showId, hideId, slideDownId) {
            slideInit(document.getElementById(slideDownId));
            slideDown(document.getElementById(slideDownId))
        }}
})();
var siemens = (function() {
    var twitterScripts = {init: function() {
            if (document.getElementById("tweet")) {
                var x = document.getElementById("tweet").childNodes[0];
                x.setAttribute("data-show-count", "true");
                x.setAttribute("data-show-screen-name", "false");
                (function(d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (!d.getElementById(id)) {
                        js = d.createElement(s);
                        js.id = id;
                        js.src = "//platform.twitter.com/widgets.js";
                        fjs.parentNode.insertBefore(js, fjs)
                    }
                })(document, "script", "twitter-wjs")
            }
        }};
    var trackingScripts = {init: function() {
            var jsTrackingPath = document.getElementById("jsTrackingPathId"), tracker, newScript;
            if (jsTrackingPath) {
                tracker = document.getElementsByTagName("body")[0];
                newScript = document.createElement("script");
                newScript.type = "text/javascript";
                newScript.src = jsTrackingPath.firstChild.innerHTML;
                tracker.appendChild(newScript)
            }
        }};
    var swipeElement = {init: function() {
            var swipeElementList = document.getElementsByClassName("swipeElement"), i, config;
            for (i = swipeElementList.length - 1; i >= 0; i--) {
                try {
                    config = JSON.parse(swipeElementList[i].firstChild.innerHTML);
                    initSwipe(config.id, config.cnt, config.touch, config.prev, config.next, config.count, config.cpos, config.ind, config.indEmpty, config.indFull, config.hrefprev, config.hrevnext, config.entryList)
                } catch (e) {
                }
            }
        }};
    return{init: function() {
            nb.findPlaceholders();
            nb.setLabel("searchinput", "searchlabel", "blur");
            nb.setLabel("pf_searchinput", "pf_keywordLabel", "blur");
            nb.setLabel("press_input", "press_Label", "blur");
            nb.setLabel("innovation_input", "press_Label", "blur");
            window.captureEvents(Event.SUBMIT);
            window.onsubmit = checkFieldsForCookie;
            autofillInputField();
            twitterScripts.init();
            trackingScripts.init();
            swipeElement.init();
            headerMenu.init()
        }}
})();
Netbiscuits.dom.domReady(siemens.init);