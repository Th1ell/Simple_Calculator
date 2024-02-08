package com.example.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import org.mariuszgromada.math.mxparser.*
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

fun calculateExpression(mathExpression: String): String {
    return Expression(mathExpression).calculate().toString()
}

fun deleteChar(mathExpression: String): String {
    if(mathExpression.isNotEmpty()) {
        return mathExpression.substring(0, mathExpression.length-1)
    } else {
        return mathExpression
    }
}

@Composable
fun CalculatorApp(modifier: Modifier = Modifier) {
    
    var mathExpression by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(modifier = modifier.weight(3f)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = mathExpression,
                maxLines = 3,
                style = TextStyle(
                    fontSize = 40.sp,
                    textAlign = TextAlign.End
                )
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = result,
                style = TextStyle(
                    fontSize = 48.sp,
                    textAlign = TextAlign.End
                )
            )
        }

        Column(
            modifier = modifier.weight(4f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    buttonText = stringResource(R.string.button_c),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression = deleteChar(mathExpression)
                        result = ""
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_open_bracket),
                    buttonColor = MaterialTheme.colorScheme.tertiary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_close_bracket),
                    buttonColor = MaterialTheme.colorScheme.tertiary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_divide),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression+= it
                    }
                )
            }
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    buttonText = stringResource(R.string.button_7),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_8),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_9),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_multiply),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression+= it
                    }
                )
            }
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    buttonText = stringResource(R.string.button_4),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_5),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_6),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_minus),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression+= it
                    }
                )
            }
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    buttonText = stringResource(R.string.button_1),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_2),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_3),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_plus),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression+= it
                    }
                )
            }
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    buttonText = stringResource(R.string.button_ac),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        mathExpression = ""
                        result = ""
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_0),
                    buttonColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_comma),
                    buttonColor = MaterialTheme.colorScheme.tertiary,
                    onClick = {
                        mathExpression+= it
                    }
                )
                CalculatorButton(
                    buttonText = stringResource(R.string.button_equals),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        result = calculateExpression(mathExpression)
                    }
                )
            }
        }

    }
}

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    buttonColor: Color,
    onClick: (String) -> Unit
) {
    Button(
        modifier = modifier
            .size(dimensionResource(R.dimen.button_size))
            .clip(CircleShape),
        onClick = {onClick(buttonText)},
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(
            text = buttonText,
            style = TextStyle(fontSize = dimensionResource(R.dimen.button_text_size).value.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    SimpleCalculatorTheme {
        CalculatorApp()
    }
}