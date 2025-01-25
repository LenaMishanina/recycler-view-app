Показать список с помощью RecyclerView
	A. Adapter даннные переносит на шаблон и отображает новый элемент в списке
	B. Список, который заполняем
	C. Шаблон элемента списка
1) добавить на экран RecyclerView
2) указать его ширину и высоту 0dp (чтобы RecyclerView подстраивался под добавленные элементы, а не обрезал их)
3) создать дата класс, описывающий модель одного элемента (в нашем случае Employee)
   ```
   data class Employee(val imageId: Int, val name: String) (картинка и имя работника)
   ```
4) создаем класс, который будет являться адаптером (в н.с. EmployeeAdapter)
   4.1) наследуем класс от RecyclerView.Adapter<ViewHolder>
	      класс адаптер работает с ViewHolder (создаем его сами) - специальный класс, который будет хранить элементы, к ним можно будет обратиться
```
	class EmployeeHolder(item: View): RecyclerView.ViewHolder(item) //item - элемент, который отрисовываем
```
   4.2) создаем шаблон элемента в layout (ConstraintLayout -> CardView -> LinearLayout --> ImageView --> TextView)
   4.3) см реализацию EmployeeAdapter в проекте
5) в коде главного экрана настроим RecyclerView и обработаем кнопку добавления элемента
```
    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)//после 3 элементов в строке переходит на следующую строку
            rcView.adapter = adapter

            btnAdd.setOnClickListener {
                if (employeeIndex > 4) employeeIndex = 0
                adapter.addEmployee(Employee(imageIdList[employeeIndex], "Employee $employeeIndex"))
                employeeIndex++
            }
        }
    }
```
