using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.SqlTypes;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using Microsoft.VisualBasic.CompilerServices;

namespace Client.Models
{
    public class Shift
    {
        [JsonPropertyName("username")]
        [NotNull]
        public string UserName { get; set; }

        [JsonPropertyName("shiftId")]
        public string ShiftId { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("companyName")]
        public string CompanyName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("jobTitle")]
        public string JobTitle { get; set; }

        [Required]
        [NotNull]
        [JsonPropertyName("date")]
        public DateTime Date { get; set; } = DateTime.Now.Date;
        
        [JsonPropertyName("preferableWorkTime")]
        public string PreferableWorkTime { get; set; }
        
        [Required, MaxLength(70)]
        [JsonPropertyName("description")] [NotNull]
        public string Description { get; set; }

        [MaxLength(70)]
        [JsonPropertyName("requirements")]
        [NotNull]
        public string Requirements { get; set; } = "No requirements";

        [Required]
        [NotNull, Range(1, 3000)]
        [JsonPropertyName("hourWage")]
        public float HourWage { get; set; }
        
        
        [JsonPropertyName("pendingList")]
        public IList<String> Pending { get; set; }
        
        [JsonPropertyName("approvedList")]
        public IList<String> Approved { get; set; } 
        
        [JsonPropertyName("rejectedList")]
        public IList<String> Rejected { get; set; }

        public Shift()
        {
            // StartDate = DateTime.Now.Date;
            // EndDate = DateTime.Now.Date;
        }

        public Shift(string userName, string shiftId, string companyName, string jobTitle, string description, string requirements, float hourWage, IList<string> pending, IList<string> approved, IList<string> rejected)
        {
            UserName = userName;
            ShiftId = shiftId;
            CompanyName = companyName;
            JobTitle = jobTitle;
            Description = description;
            Requirements = requirements;
            HourWage = hourWage;
            Pending = pending;
            Approved = approved;
            Rejected = rejected;
        }

        public override string ToString()
        {
            string s = "";
            s += UserName + " ";
            s += CompanyName + " ";
            s += JobTitle + " ";
            s += Date + " ";
            s += PreferableWorkTime + " ";
            s += HourWage + " ";
            s += Description + " ";
            s += Requirements + " ";
            s += Pending + " ";
            s += Approved + " ";
            s += Rejected + " ";
            return s;
        }
    }
    
    public class ValidDate : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            DateTime date = DateTime.Now.Date;
            DateTime val = (DateTime) value;
            if (val >= date)
            {
                return ValidationResult.Success;
            }

            Console.Out.WriteLine("Date error");
            return new ValidationResult(
                "Start date can't be bigger than end date");
        }
    }
}