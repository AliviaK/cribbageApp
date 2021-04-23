const highlightSelection = (choice) => {
    const limit = 2;
    if (choice.className == "chosen") {
        choice.className = "not-chosen";
    } else if (document.getElementsByClassName("chosen").length < limit) {
        choice.className = "chosen";
    }

    let checkBoxGroup = document.forms['crib']['cardsForCrib[]'];
    for (let i = 0; i < checkBoxGroup.length; i++) {
        checkBoxGroup[i].onclick = function() {
            let checkedCount = 0;
            for (let i = 0; i < checkBoxGroup.length; i++) {
                checkedCount += (checkBoxGroup[i].checked) ? 1 : 0;
            }
            if (checkedCount > limit) {
                alert("You can select maximum of " + limit + " checkboxes.");
                this.checked = false;
            }
        }
    }
}

