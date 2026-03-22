import './index.css';

const taskInput = document.getElementById("task-input");
const addTaskBtn = document.getElementById("add-task-btn");
const taskList = document.getElementById("task-list");

const handleAddTask = async () => {
  const title = taskInput.value.trim();

  await window.api.addTask(title);
}

addTaskBtn.addEventListener('click', handleAddTask);

const renderTasks = async () => {
  const tasks = await window.api.getAllTasks();

  tasks.forEach(task => {
    const li = document.createElement('li');
    const titleSpan = document.createElement('span')
    titleSpan.textContent = task.title;
    li.appendChild(titleSpan)

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.checked = !!task.completed;
    checkbox.addEventListener('change', async () => {
      await window.api.markComplete({id:task.id, completed: checkbox.checked ? 1 : 0});
    });

    li.appendChild(checkbox);
    taskList.appendChild(li);

  })
}

renderTasks();