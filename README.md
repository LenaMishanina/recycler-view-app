Новая возможность добавить элемент (сотрудника) с помощью нового окна EditActivity

Для передачи объекта Employee был использован Serializable
```
editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
  if (it.resultCode == RESULT_OK && it.data != null) {
    adapter.addEmployee(it.data?.getSerializableExtra("employee") as Employee)
  }
}
```

Передача данных между окнами осуществляется с помощью registerForActivityResult

```
class MainActivity : AppCompatActivity() {
    lateinit var editLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                adapter.addEmployee(it.data?.getSerializableExtra("employee") as Employee)
            }
        }
        init()
    }
    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)//после 3 элементов в строке переходит на следующую строку
            rcView.adapter = adapter
            btnAdd.setOnClickListener {
                val intent = Intent(this@MainActivity, EditActivity::class.java)
                editLauncher.launch(intent)
            }
        }
    }
}
```

```
class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initButtons()
    }
    private fun initButtons() = with(binding){
        btnDone.setOnClickListener {
            val employee = Employee(imageId, edTitle.text.toString(), edDesc.text.toString())
            val intent = Intent(this@EditActivity, MainActivity::class.java)
            intent.putExtra("employee", employee)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
```
