// add pageTitle
const pageTitle = "My Shopping List";
// add groceries
const groceries = ["Milk", "Bread", "Egg", "Tomatoes", "Soda",
  "Meat", "Parsley", "Lemon", "Banana", "Strawberry"]
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText = pageTitle;
}
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const list = document.getElementById('groceries');
  groceries.forEach(element => {
    const container = document.createElement('li');
    container.innerText = element;
    list.appendChild(container);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const listItem = document.querySelectorAll('#groceries li');

  listItem.forEach(element => {
    element.setAttribute('class', 'completed');
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
