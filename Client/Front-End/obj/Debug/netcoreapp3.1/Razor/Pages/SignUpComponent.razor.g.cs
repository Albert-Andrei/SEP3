#pragma checksum "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "0ea1c2b0e2868659f264617978699f658a8c4374"
// <auto-generated/>
#pragma warning disable 1591
namespace AndriuhaAssignment.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using AndriuhaAssignment;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using AndriuhaAssignment.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
using AndriuhaAssignment.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
using AndriuhaAssignment.Data;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/sign-up")]
    public partial class SignUpComponent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(0);
            __builder.AddAttribute(1, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 8 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                  newUser

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(2, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 8 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                           CreateNewUser

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(3, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.AddMarkupContent(4, "\r\n    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(5);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(6, "\r\n    \r\n    ");
                __builder2.OpenElement(7, "div");
                __builder2.AddAttribute(8, "class", "sign-up");
                __builder2.AddMarkupContent(9, "\r\n        ");
                __builder2.AddMarkupContent(10, @"<div class=""auth-sidebar"">
            <div class=""auth-sidebar-content"">
                <div class=""header"">
                    <a href=""/"" class=""signup-logo"">Logo</a>
                    <h1>Discover all available possibilities of our platform</h1>
                </div>
            </div>
        </div>

        <div class=""calhoz""></div>

        ");
                __builder2.OpenElement(11, "div");
                __builder2.AddAttribute(12, "class", "content");
                __builder2.AddMarkupContent(13, "\r\n            ");
                __builder2.OpenElement(14, "main");
                __builder2.AddMarkupContent(15, "\r\n                ");
                __builder2.OpenElement(16, "div");
                __builder2.AddAttribute(17, "class", "auth-content");
                __builder2.AddMarkupContent(18, "\r\n\r\n                    ");
                __builder2.AddMarkupContent(19, "<h2>Sign up to JPool</h2>\r\n\r\n                    <hr class=\"divider\">\r\n\r\n                    ");
                __builder2.OpenElement(20, "div");
                __builder2.AddAttribute(21, "class", "forms");
                __builder2.AddAttribute(22, "autocomplete", "on");
                __builder2.AddMarkupContent(23, "\r\n                        ");
                __builder2.OpenElement(24, "div");
                __builder2.AddAttribute(25, "class", "name");
                __builder2.AddMarkupContent(26, "\r\n                            ");
                __builder2.OpenElement(27, "div");
                __builder2.AddAttribute(28, "class", "box");
                __builder2.AddMarkupContent(29, "\r\n                                ");
                __builder2.OpenElement(30, "fieldset");
                __builder2.AddMarkupContent(31, "\r\n                                    ");
                __builder2.AddMarkupContent(32, "<label>First Name</label>\r\n                                    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(33);
                __builder2.AddAttribute(34, "autocomplete", "given-name");
                __builder2.AddAttribute(35, "class", "text-input");
                __builder2.AddAttribute(36, "type", "text");
                __builder2.AddAttribute(37, "name", "given-name");
                __builder2.AddAttribute(38, "required", true);
                __builder2.AddAttribute(39, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 38 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                            newUser.FirstName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(40, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => newUser.FirstName = __value, newUser.FirstName))));
                __builder2.AddAttribute(41, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => newUser.FirstName));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(42, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(43, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(44, "\r\n                            ");
                __builder2.OpenElement(45, "div");
                __builder2.AddAttribute(46, "class", "box");
                __builder2.AddMarkupContent(47, "\r\n                                ");
                __builder2.OpenElement(48, "fieldset");
                __builder2.AddMarkupContent(49, "\r\n                                    ");
                __builder2.AddMarkupContent(50, "<label>Last Name</label>\r\n                                    ");
                __builder2.OpenElement(51, "input");
                __builder2.AddAttribute(52, "autocomplete", "family-name");
                __builder2.AddAttribute(53, "class", "text-input");
                __builder2.AddAttribute(54, "type", "text");
                __builder2.AddAttribute(55, "name", "family-name");
                __builder2.AddAttribute(56, "required", true);
                __builder2.AddAttribute(57, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 46 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                  newUser.LastName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(58, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.LastName = __value, newUser.LastName));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(59, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(60, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(61, "\r\n                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(62, "\r\n\r\n                        ");
                __builder2.OpenElement(63, "div");
                __builder2.AddAttribute(64, "class", "name");
                __builder2.AddMarkupContent(65, "\r\n                            ");
                __builder2.OpenElement(66, "div");
                __builder2.AddAttribute(67, "class", "box");
                __builder2.AddMarkupContent(68, "\r\n                                ");
                __builder2.OpenElement(69, "fieldset");
                __builder2.AddMarkupContent(70, "\r\n                                    ");
                __builder2.AddMarkupContent(71, "<label>Username</label>\r\n                                    ");
                __builder2.OpenElement(72, "input");
                __builder2.AddAttribute(73, "autocomplete", "email");
                __builder2.AddAttribute(74, "class", "text-input");
                __builder2.AddAttribute(75, "type", "text");
                __builder2.AddAttribute(76, "name", "email");
                __builder2.AddAttribute(77, "required", true);
                __builder2.AddAttribute(78, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 57 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                  newUser.UserName

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(79, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.UserName = __value, newUser.UserName));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(80, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(81, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(82, "\r\n                            ");
                __builder2.OpenElement(83, "div");
                __builder2.AddAttribute(84, "class", "box");
                __builder2.AddMarkupContent(85, "\r\n                                ");
                __builder2.OpenElement(86, "fieldset");
                __builder2.AddMarkupContent(87, "\r\n                                    ");
                __builder2.AddMarkupContent(88, "<label>Phone Nr.</label>\r\n                                    ");
                __builder2.OpenElement(89, "input");
                __builder2.AddAttribute(90, "autocomplete", "tel");
                __builder2.AddAttribute(91, "class", "text-input");
                __builder2.AddAttribute(92, "type", "text");
                __builder2.AddAttribute(93, "name", "tel");
                __builder2.AddAttribute(94, "required", true);
                __builder2.AddAttribute(95, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 65 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                  newUser.PhoneNr

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(96, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.PhoneNr = __value, newUser.PhoneNr));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(97, "\r\n                                    ");
                __Blazor.AndriuhaAssignment.Pages.SignUpComponent.TypeInference.CreateValidationMessage_0(__builder2, 98, 99, 
#nullable restore
#line 66 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                              () => newUser.PhoneNr

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(100, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(101, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(102, "\r\n                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(103, "\r\n\r\n                        ");
                __builder2.OpenElement(104, "div");
                __builder2.AddAttribute(105, "class", "name");
                __builder2.AddMarkupContent(106, "\r\n                            ");
                __builder2.OpenElement(107, "div");
                __builder2.AddAttribute(108, "class", "box");
                __builder2.AddMarkupContent(109, "\r\n                                ");
                __builder2.OpenElement(110, "fieldset");
                __builder2.AddMarkupContent(111, "\r\n                                    ");
                __builder2.AddMarkupContent(112, "<label>Password</label>\r\n                                    ");
                __builder2.OpenElement(113, "input");
                __builder2.AddAttribute(114, "placeholder", "8+ characters ");
                __builder2.AddAttribute(115, "class", "text-input");
                __builder2.AddAttribute(116, "type", "password");
                __builder2.AddAttribute(117, "required", true);
                __builder2.AddAttribute(118, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 77 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                  newUser.Password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(119, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.Password = __value, newUser.Password));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(120, "\r\n                                    ");
                __Blazor.AndriuhaAssignment.Pages.SignUpComponent.TypeInference.CreateValidationMessage_1(__builder2, 121, 122, 
#nullable restore
#line 78 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                              () => newUser.Password

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(123, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(124, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(125, "\r\n                            ");
                __builder2.OpenElement(126, "div");
                __builder2.AddAttribute(127, "class", "box");
                __builder2.AddMarkupContent(128, "\r\n                                ");
                __builder2.OpenElement(129, "fieldset");
                __builder2.AddMarkupContent(130, "\r\n                                    ");
                __builder2.AddMarkupContent(131, "<label>Confirm password</label>\r\n                                    <input placeholder=\"Same as previous\" class=\"text-input\" type=\"password\" required>\r\n                                    ");
                __Blazor.AndriuhaAssignment.Pages.SignUpComponent.TypeInference.CreateValidationMessage_2(__builder2, 132, 133, 
#nullable restore
#line 87 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                              () => newUser.Password

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(134, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(135, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(136, "\r\n                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(137, "\r\n\r\n                        ");
                __builder2.OpenElement(138, "div");
                __builder2.AddAttribute(139, "class", "longbox");
                __builder2.AddAttribute(140, "autocomplete", "On");
                __builder2.AddMarkupContent(141, "\r\n                            ");
                __builder2.OpenElement(142, "div");
                __builder2.AddAttribute(143, "class", "email");
                __builder2.AddMarkupContent(144, "\r\n                                ");
                __builder2.OpenElement(145, "fieldset");
                __builder2.AddMarkupContent(146, "\r\n                                    ");
                __builder2.AddMarkupContent(147, "<label>Email</label>\r\n                                    ");
                __builder2.OpenElement(148, "input");
                __builder2.AddAttribute(149, "autocomplete", "email");
                __builder2.AddAttribute(150, "class", "text-input");
                __builder2.AddAttribute(151, "type", "text");
                __builder2.AddAttribute(152, "name", "email");
                __builder2.AddAttribute(153, "required", true);
                __builder2.AddAttribute(154, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 97 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                               newUser.Email

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(155, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.Email = __value, newUser.Email));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(156, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(157, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(158, "\r\n                            ");
                __builder2.OpenElement(159, "div");
                __builder2.AddAttribute(160, "class", "city");
                __builder2.AddMarkupContent(161, "\r\n                                ");
                __builder2.OpenElement(162, "div");
                __builder2.AddAttribute(163, "class", "name");
                __builder2.AddMarkupContent(164, "\r\n                                    ");
                __builder2.OpenElement(165, "div");
                __builder2.AddAttribute(166, "class", "box");
                __builder2.AddMarkupContent(167, "\r\n                                        ");
                __builder2.OpenElement(168, "fieldset");
                __builder2.AddMarkupContent(169, "\r\n                                            ");
                __builder2.AddMarkupContent(170, "<label>City</label>\r\n                                            ");
                __builder2.OpenElement(171, "input");
                __builder2.AddAttribute(172, "autocomplete", "On");
                __builder2.AddAttribute(173, "class", "text-input");
                __builder2.AddAttribute(174, "type", "text");
                __builder2.AddAttribute(175, "name", "address-level2");
                __builder2.AddAttribute(176, "required", true);
                __builder2.AddAttribute(177, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 106 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                                                newUser.City

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(178, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => newUser.City = __value, newUser.City));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(179, "\r\n                                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(180, "\r\n                                    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(181, "\r\n                                    ");
                __builder2.OpenElement(182, "div");
                __builder2.AddAttribute(183, "class", "dropdown-state");
                __builder2.AddMarkupContent(184, "\r\n                                        ");
                __builder2.AddMarkupContent(185, "<label for=\"state\">Status:</label>\r\n                                        ");
                __builder2.OpenElement(186, "select");
                __builder2.AddAttribute(187, "name", "type");
                __builder2.AddAttribute(188, "class", "state");
                __builder2.AddAttribute(189, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 111 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                                                  selectedType

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(190, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => selectedType = __value, selectedType));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.AddMarkupContent(191, "\r\n");
#nullable restore
#line 112 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                             foreach (var t in type)
                                            {

#line default
#line hidden
#nullable disable
                __builder2.AddContent(192, "                                                ");
                __builder2.OpenElement(193, "option");
                __builder2.AddAttribute(194, "value", 
#nullable restore
#line 114 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                               t

#line default
#line hidden
#nullable disable
                );
                __builder2.AddContent(195, 
#nullable restore
#line 114 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                                  t

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(196, "\r\n");
#nullable restore
#line 115 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                            }

#line default
#line hidden
#nullable disable
                __builder2.AddContent(197, "                                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(198, "\r\n                                        ");
                __Blazor.AndriuhaAssignment.Pages.SignUpComponent.TypeInference.CreateValidationMessage_3(__builder2, 199, 200, 
#nullable restore
#line 117 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                                                  () => newUser.UserType

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(201, "\r\n                                    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(202, "\r\n                                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(203, "\r\n                            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(204, "\r\n                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(205, "\r\n                    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(206, "\r\n                    ");
                __builder2.OpenElement(207, "div");
                __builder2.AddAttribute(208, "style", "color:red");
                __builder2.AddContent(209, 
#nullable restore
#line 123 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
                                            errorMessage

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(210, "\r\n                    ");
                __builder2.AddMarkupContent(211, "<button type=\"submit\" class=\"signupBtn\">Create Account</button>\r\n                ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(212, "\r\n            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(213, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(214, "\r\n    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(215, "\r\n");
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 131 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Pages\SignUpComponent.razor"
       
    private string errorMessage;
    private User newUser = new User();
    List<string> type = new List<string>() { "Employee", "Employer"};
    string selectedType = "Employee";

    private void CreateNewUser()
    {
        newUser.UserType = selectedType;
        UserService.CreateUserAsync(newUser);
        NavigationManager.NavigateTo("/log-in");
    }
    
    

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IUserService UserService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
namespace __Blazor.AndriuhaAssignment.Pages.SignUpComponent
{
    #line hidden
    internal static class TypeInference
    {
        public static void CreateValidationMessage_0<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_1<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_2<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_3<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
    }
}
#pragma warning restore 1591